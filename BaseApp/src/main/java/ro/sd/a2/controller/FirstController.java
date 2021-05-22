package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.entity.UserProfile;
import ro.sd.a2.service.UserService;


@Controller
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ModelAndView showProfile() {
        //validation if needed
        //shall we log a little?
        ModelAndView mav = new ModelAndView();
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName("Vasi");

        //mav.addObject("userStudent", userProfile.getFirstName());
        //mav.addObject("numeStudent", user.getFirstName());
        // adaugi x obiecte
        //mav.setViewName("profile");
        //log the final outcome: Success y?
        return mav;
    }

}
