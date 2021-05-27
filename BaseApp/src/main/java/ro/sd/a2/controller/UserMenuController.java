package ro.sd.a2.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("user")
public class UserMenuController {
    private static final Logger log = LoggerFactory.getLogger(UserMenuController.class);



    @GetMapping("index")
    public ModelAndView signInForm() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.err.println(currentUserName);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/index");

        return modelAndView;
    }

    @PostMapping(value = "index", params = "action=buy")
    public RedirectView buyTicket(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("buyTicket");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("index");
        }
        return redirectView;
    }

    @PostMapping(value = "index", params = "action=edit")
    public RedirectView editProfile(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("editProfile");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("index");
        }
        return redirectView;
    }

    @PostMapping(value = "index", params = "action=transactions")
    public RedirectView showTransactions(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("userTransactions");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("index");
        }
        return redirectView;
    }



}
