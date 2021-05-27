package ro.sd.a2.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.entity.UserProfile;
import ro.sd.a2.service.UserService;

@Controller
public class LogInController {
    private static final Logger log = LoggerFactory.getLogger(LogInController.class);


    @GetMapping("/logIn")
    public String logInForm() {
        return "logIn";
    }

    @GetMapping("/forbidden")
    public String forbiddenForm() {


        return "forbidden";
    }

}
