package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.AddressDto;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.service.UserService;

@Controller
public class UserMenuController {
    private static final Logger log = LoggerFactory.getLogger(FirstController.class);
    private String loggedInUserID;

    @Autowired
    private UserService userService;

    @GetMapping("/userMenu")
    public ModelAndView signInForm(@RequestParam(name="userId", required = true) String userId) {

        loggedInUserID = userId;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userMenu");

        return modelAndView;
    }

    @PostMapping(value = "/userMenu", params = "action=logOut")
    public RedirectView logOut(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("logIn");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("userMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }

    @PostMapping(value = "/userMenu", params = "action=buy")
    public RedirectView buyTicket(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("buyTicket?userId="+loggedInUserID);
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("userMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }

    @PostMapping(value = "/userMenu", params = "action=edit")
    public RedirectView editProfile(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("editProfile?userId="+loggedInUserID);
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("userMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }

    @PostMapping(value = "/userMenu", params = "action=transactions")
    public RedirectView showTransactions(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("userTransactions?userId="+loggedInUserID);
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("userMenu?userId="+loggedInUserID);
        }
        return redirectView;
    }



}
