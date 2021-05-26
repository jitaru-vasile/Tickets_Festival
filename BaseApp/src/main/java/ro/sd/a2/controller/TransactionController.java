package ro.sd.a2.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);
    @Autowired
    TransactionService transactionService;
    @Autowired
    TicketService ticketService;


    @Autowired
    UserService userService;
    private UserDTO userDTO;
    private List<TicketDTO> ticketDTOS;
    private List<TransactionDTO> transactionDTOList;

    @GetMapping("admin/transactions")
    public ModelAndView adminTransactions() {

        List<TransactionDTO> transactionDTOList = transactionService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("transactionList",transactionDTOList);
        modelAndView.setViewName("admin/transactionsAdmin");

        return modelAndView;
    }

    @GetMapping("user/userTransactions")
    public ModelAndView userTransactions() {
        String currentUserName = "";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        userDTO = userService.getUserByEmail(currentUserName);
        transactionDTOList = transactionService.getAllByIdUser(userDTO);
        ticketDTOS = ticketService.getAllTickets();
        int quantity = 1;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets",ticketDTOS);
        modelAndView.addObject("quantity",quantity);
        modelAndView.addObject("transactionList",transactionDTOList);
        modelAndView.setViewName("user/userTransactions");

        return modelAndView;
    }

    @PostMapping(value = "user/userTransactions/delete")
        public ModelAndView delete(@Valid int transactionSelected){

        TransactionDTO transaction = transactionDTOList.get(transactionSelected);
        transactionService.remove(transaction);
        return userTransactions();
    }

    @PostMapping(value = "user/userTransactions/update")
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

        return userTransactions();
    }



}
