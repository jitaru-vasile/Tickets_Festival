package ro.sd.a2.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.DTO.TransactionDTO;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.service.TicketService;
import ro.sd.a2.service.TransactionService;
import ro.sd.a2.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);
    @Autowired
    TransactionService transactionService;
    @Autowired
    TicketService ticketService;


    @Autowired
    UserService userService;
    private String loggedInUserID;
    private UserDTO userDTO;
    private List<TicketDTO> ticketDTOS;
    private List<TransactionDTO> transactionDTOList;

    @GetMapping("/transactions")
    public ModelAndView adminTransactions(@RequestParam(name = "userId" ,required = true)String userID) {
        loggedInUserID = userID;
        List<TransactionDTO> transactionDTOList = transactionService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("transactionList",transactionDTOList);
        modelAndView.setViewName("transactionsAdmin");

        return modelAndView;
    }

    @GetMapping("/userTransactions")
    public ModelAndView userTransactions(@RequestParam(name = "userId" ,required = true)String userID) {
        loggedInUserID = userID;
        userDTO = userService.getUserByID(userID);
        transactionDTOList = transactionService.getAllByIdUser(userDTO);
        ticketDTOS = ticketService.getAllTickets();
        int quantity = 1;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets",ticketDTOS);
        modelAndView.addObject("quantity",quantity);
        modelAndView.addObject("transactionList",transactionDTOList);
        modelAndView.setViewName("userTransactions");

        return modelAndView;
    }

    @PostMapping(value = "/userTransactions/delete")
        public ModelAndView delete(@Valid int transactionSelected){
        System.err.println("S-a apelat functia");
        //int i = Integer.parseInt(transactionSelected);
        TransactionDTO transaction = transactionDTOList.get(transactionSelected);
        transactionService.remove(transaction);
        return userTransactions(loggedInUserID);
    }

    @PostMapping(value = "/userTransactions/update")
    public ModelAndView update(@Valid int transactionSelectedUpdate, @Valid String ticketSelected, @RequestParam(value = "quantity",required = false) int quantity){
        TransactionDTO transactionToUpdate = transactionDTOList.get(transactionSelectedUpdate);
        TicketDTO ticketDTO = new TicketDTO();
        for(TicketDTO dto:ticketDTOS){
            if(dto.getName().equals(ticketSelected)){
                ticketDTO = dto;
                break;
            }
        }
        transactionService.update(transactionToUpdate,ticketDTO,quantity);

        return userTransactions(loggedInUserID);
    }



}
