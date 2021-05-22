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
    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/logIn")
    public ModelAndView logInForm() {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO userDTO = new UserDTO();
        String email = "";
        String password = "";
        modelAndView.addObject("userDto",userDTO);
        modelAndView.addObject("email",email);
        modelAndView.addObject("password", password);
        modelAndView.setViewName("logIn");

        return modelAndView;
    }

    @PostMapping(value = "/logIn", params = "action=logIn")
    public RedirectView logIn(@ModelAttribute("email") String email, @ModelAttribute("password") String password){
        RedirectView redirectView = new RedirectView();

        try{
            UserDTO userDTO = UserDTO.builder().password(password).email(email).build();
            UserDTO loggedInUser = userService.logIn(userDTO);
            String id = loggedInUser.getId();
            if(!loggedInUser.isPermission())
                redirectView.setUrl("userMenu?userId="+id);
            else
                redirectView.setUrl("adminMenu?userId="+id);
        }
        catch (Exception e){
            log.error("There is no user with given credentials");
            redirectView.setUrl("logIn");
        }
        return redirectView;
    }
}
