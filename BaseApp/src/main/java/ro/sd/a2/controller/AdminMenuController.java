package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminMenuController {
    private static final Logger log = LoggerFactory.getLogger(AdminMenuController.class);

    @Autowired
    private UserService userService;

    private String loggedInUserID;

    @GetMapping("index")
    public ModelAndView editProfileForm() {
        loggedInUserID = "asmdiam";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/index");

        return modelAndView;
    }

    @PostMapping(value = "index", params = "action=tickets")
    public RedirectView ticket(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("addTicket");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }
        return redirectView;
    }

    @PostMapping(value = "index", params = "action=ticketsDU")
    public RedirectView ticketDeleteUpdate(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("ticketDU");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }
        return redirectView;
    }

    @PostMapping(value = "index", params = "action=users")
    public RedirectView seeUsers(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("users");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }
        return redirectView;
    }

    @PostMapping(value = "index", params = "action=transactions")
    public RedirectView seeTransactions(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("transactions");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }
        return redirectView;
    }

    @PostMapping(value = "index", params = "action=artists")
    public RedirectView seeArtists(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("artists");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }
        return redirectView;
    }

    @PostMapping(value = "index", params = "action=music")
    public RedirectView seeMusic(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("music");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }
        return redirectView;
    }

    @PostMapping(value = "index", params = "action=stage")
    public RedirectView seeStages(){
        RedirectView redirectView = new RedirectView();
        try{
            redirectView.setUrl("stage");
        }
        catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }
        return redirectView;
    }

}
