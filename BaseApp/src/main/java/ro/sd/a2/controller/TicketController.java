package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.PayloadDTO;
import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.DTO.TransactionDTO;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.Exception.NullFieldException;
import ro.sd.a2.Strategy.Context;
import ro.sd.a2.Strategy.GenerateTicketPDF;
import ro.sd.a2.Strategy.GenerateTicketText;
import ro.sd.a2.config.RabbitSender;
import ro.sd.a2.service.TicketService;
import ro.sd.a2.service.TransactionService;
import ro.sd.a2.service.UserService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
public class TicketController {
    private static final Logger log = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketService ticketService;

    @Autowired
    private RabbitSender rabbitSender;

    @Autowired
    private TransactionService transactionService;

    @Autowired UserService userService;
    private List<TicketDTO> ticketDTOList;

    @Autowired
    private RestTemplate restTemplate;

    private String loggedInUserId;
    private UserDTO loggedInUser;

    @GetMapping("/buyTicket")
    public ModelAndView buyTicketForm(@RequestParam(name="userId", required = true) String userId) {

       loggedInUserId = userId;
       loggedInUser = userService.getUserByID(loggedInUserId);
       ticketDTOList = ticketService.getAllTickets();
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("tickets",ticketDTOList);
       modelAndView.setViewName("buyTicket");

       return modelAndView;
    }

    @GetMapping("/addTicket")
    public ModelAndView addTicketForm(@RequestParam(name="userId", required = true) String userId) {
        loggedInUserId = userId;
        ModelAndView modelAndView = new ModelAndView();
        TicketDTO ticketDTO = new TicketDTO();
        modelAndView.addObject("ticketDto",ticketDTO);
        modelAndView.setViewName("addTicket");
        return modelAndView;
    }

    @GetMapping("/ticketDU")
    public ModelAndView updateDeleteTicketForm(@RequestParam(name="userId", required = true) String userId) {

        int price = 0;
        LocalDate startDate = LocalDate.now();
        LocalDate stopDate = LocalDate.now();
        String name = "";
        loggedInUserId = userId;
        loggedInUser = userService.getUserByID(loggedInUserId);
        ticketDTOList = ticketService.getAllTickets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets",ticketDTOList);
        modelAndView.addObject("name",name);
        modelAndView.addObject("price",price);
        modelAndView.addObject("startDate",startDate);
        modelAndView.addObject("stopDate",stopDate);
        modelAndView.setViewName("ticketDU");

        return modelAndView;
    }

    @PostMapping(value = "/addTicket", params = "action=addTicket")
    public RedirectView addTicketAction(@ModelAttribute("ticketDto") TicketDTO ticketDTO){
        RedirectView redirectView = new RedirectView();
        try {
            ticketDTO.setId(UUID.randomUUID().toString());
            ticketService.insert(ticketDTO);
            redirectView.setUrl("http://localhost:7799/app/adminMenu?userId="+loggedInUserId);
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/addTicket?userId="+loggedInUserId);
        }
        return redirectView;
    }

    @PostMapping(value = "/buyTicket")
    public RedirectView buyTicket(@Valid String ticketSelected){
        String ticketId = "";
        RedirectView redirectView = new RedirectView();
        try {
            for (TicketDTO ticket : ticketDTOList) {
                if (ticket.getName().equals(ticketSelected)) {
                    System.err.println(ticket.getId());
                    ticketId = ticket.getId();
                    break;
                }
            }
            TicketDTO ticketDTO = ticketService.getTicketById(ticketId);
            transactionService.saveTransaction(loggedInUser, ticketDTO);
            Context context = new Context(new GenerateTicketPDF());
            context.executeStrategy(ticketDTO,loggedInUser);
            Context context1 = new Context(new GenerateTicketText());
            context1.executeStrategy(ticketDTO,loggedInUser);
            PayloadDTO payloadDTO = PayloadDTO.builder().price(ticketDTO.getPrice())
                    .ticketName(ticketDTO.getName())
                    .ticketPath(loggedInUser.getFirstName()+loggedInUser.getLastName()+"ticket")
                    .userEmail(loggedInUser.getEmail())
                    .userFullName(loggedInUser.getFirstName() + " " + loggedInUser.getLastName()).build();
            rabbitSender.send(payloadDTO);
            redirectView.setUrl("http://localhost:7799/app/userMenu?userId="+loggedInUserId);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/buyTicket?userId="+loggedInUserId);
        }
        return redirectView;
    }

    @PostMapping(value = "/ticketDU/delete")
    public RedirectView delete(@Valid int ticketSelected){
        RedirectView redirectView = new RedirectView();
        try {
            String ticketToRemoveID = ticketDTOList.get(ticketSelected).getId();
            ticketService.delete(ticketToRemoveID);
            redirectView.setUrl("http://localhost:7799/app/adminMenu?userId="+loggedInUserId);
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/ticketDU?userId="+loggedInUserId);
        }
        return redirectView;
    }

    @PostMapping(value = "/ticketDU/update")
    public RedirectView update(@Valid int ticketSelected,
                               @RequestParam(value = "price",required = false) int price,
                               @RequestParam(value = "name",required = false) String name,
                               @RequestParam(value = "startDate",required = false)  String startDateS,
                               @RequestParam(value = "stopDate",required = false)  String stopDateS
                               ){
        RedirectView redirectView = new RedirectView();
        try {
            LocalDate stopDate = LocalDate.parse(stopDateS);
            LocalDate startDate = LocalDate.parse(startDateS);
            String ticketId = ticketDTOList.get(ticketSelected).getId();
            TicketDTO ticketDTO = TicketDTO.builder().id(ticketId)
                    .name(name)
                    .type("normal")
                    .price(price)
                    .endDate(stopDate)
                    .startDate(startDate).build();
            ticketService.update(ticketDTO);
            redirectView.setUrl("http://localhost:7799/app/adminMenu?userId="+loggedInUserId);
        }catch (NullFieldException e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/ticketDU?userId="+loggedInUserId);
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/ticketDU?userId="+loggedInUserId);
        }
        return redirectView;
    }

}
