package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.AddressDto;
import ro.sd.a2.DTO.UserDTO;

import java.util.UUID;

@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(SignInController.class);

    @GetMapping("/index")
    public String indexForm() {
        return "index";
    }

    @PostMapping(value = "/index", params = "action=signIn")
    public RedirectView signIn(){
        RedirectView redirectView = new RedirectView();
        try{

            redirectView.setUrl("http://localhost:7799/app/signIn");
        }
        catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            redirectView.setUrl("http://localhost:7799/app/index");
        }
        return redirectView;
    }

    @PostMapping(value = "/index", params = "action=artists")
    public RedirectView seeArtists(){
        RedirectView redirectView = new RedirectView();
        try{

            redirectView.setUrl("http://localhost:7799/app/artists");
        }
        catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            redirectView.setUrl("http://localhost:7799/app/index");
        }
        return redirectView;
    }

    @PostMapping(value = "/index", params = "action=schedule")
    public RedirectView seeSchedule(){
        RedirectView redirectView = new RedirectView();
        try{

            redirectView.setUrl("http://localhost:7799/app/schedule");
        }
        catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            redirectView.setUrl("http://localhost:7799/app/index");
        }
        return redirectView;
    }

}
