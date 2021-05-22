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
import ro.sd.a2.service.UserService;

@Controller
public class AdminMenuController {
    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private UserService userService;

    private String loggedInUserID;

    @GetMapping("/adminMenu")
    public ModelAndView editProfileForm(@RequestParam(name = "userId" ,required = true)String userID) {
        loggedInUserID = userID;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminMenu");

        return modelAndView;
    }

    @PostMapping(value = "/adminMenu", params = "action=logOut")
    public RedirectView logOut(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("logIn");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("adminMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }

    @PostMapping(value = "/adminMenu", params = "action=tickets")
    public RedirectView ticket(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("addTicket?userId="+loggedInUserID);
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("adminMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }

    @PostMapping(value = "/adminMenu", params = "action=ticketsDU")
    public RedirectView ticketDeleteUpdate(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("ticketDU?userId="+loggedInUserID);
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("adminMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }

    @PostMapping(value = "/adminMenu", params = "action=users")
    public RedirectView seeUsers(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("users?userId="+loggedInUserID);
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("adminMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }

    @PostMapping(value = "/adminMenu", params = "action=transactions")
    public RedirectView seeTransactions(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("transactions?userId="+loggedInUserID);
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("adminMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }




}
