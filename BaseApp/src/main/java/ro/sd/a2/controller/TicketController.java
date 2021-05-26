package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.PayloadDTO;
import ro.sd.a2.DTO.TicketDTO;
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

    private UserDTO loggedInUser;

    @GetMapping("user/buyTicket")
    public ModelAndView buyTicketForm() {
        String currentUserName = "";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }

       loggedInUser = userService.getUserByEmail(currentUserName);
       ticketDTOList = ticketService.getAllTickets();
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("tickets",ticketDTOList);
       modelAndView.setViewName("user/buyTicket");

       return modelAndView;
    }

    @GetMapping("admin/addTicket")
    public ModelAndView addTicketForm() {

        ModelAndView modelAndView = new ModelAndView();
        TicketDTO ticketDTO = new TicketDTO();
        modelAndView.addObject("ticketDto",ticketDTO);
        modelAndView.setViewName("admin/addTicket");
        return modelAndView;
    }

    @GetMapping("admin/ticketDU")
    public ModelAndView updateDeleteTicketForm() {

        int price = 0;
        LocalDate startDate = LocalDate.now();
        LocalDate stopDate = LocalDate.now();
        String name = "";
        ticketDTOList = ticketService.getAllTickets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets",ticketDTOList);
        modelAndView.addObject("name",name);
        modelAndView.addObject("price",price);
        modelAndView.addObject("startDate",startDate);
        modelAndView.addObject("stopDate",stopDate);
        modelAndView.setViewName("admin/ticketDU");

        return modelAndView;
    }

    @PostMapping(value = "admin/addTicket", params = "action=addTicket")
    public RedirectView addTicketAction(@ModelAttribute("ticketDto") TicketDTO ticketDTO){
        RedirectView redirectView = new RedirectView();
        try {
            ticketDTO.setId(UUID.randomUUID().toString());
            ticketService.insert(ticketDTO);
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/addTicket");
        }
        return redirectView;
    }

    @PostMapping(value = "user/buyTicket")
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
           /* PayloadDTO payloadDTO = PayloadDTO.builder().price(ticketDTO.getPrice())
                    .ticketName(ticketDTO.getName())
                    .ticketPath(loggedInUser.getFirstName()+loggedInUser.getLastName()+"ticket")
                    .userEmail(loggedInUser.getEmail())
                    .userFullName(loggedInUser.getFirstName() + " " + loggedInUser.getLastName()).build();
            rabbitSender.send(payloadDTO);*/
            redirectView.setUrl("http://localhost:7799/app/user/index");
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/buyTicket");
        }
        return redirectView;
    }

    @PostMapping(value = "admin/ticketDU/delete")
    public RedirectView delete(@Valid int ticketSelected){
        RedirectView redirectView = new RedirectView();
        try {
            String ticketToRemoveID = ticketDTOList.get(ticketSelected).getId();
            ticketService.delete(ticketToRemoveID);
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/ticketDU");
        }
        return redirectView;
    }

    @PostMapping(value = "admin/ticketDU/update")
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
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }catch (NullFieldException e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/ticketDU");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/ticketDU");
        }
        return redirectView;
    }

}
