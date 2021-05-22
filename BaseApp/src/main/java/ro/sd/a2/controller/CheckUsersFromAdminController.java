package ro.sd.a2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.service.UserService;

import java.util.List;

@Controller
public class CheckUsersFromAdminController {

    @Autowired
    private UserService userService;
    private String loggedInUserID;


    @GetMapping("/users")
    public ModelAndView editProfileForm(@RequestParam(name = "userId" ,required = true)String userID) {
        loggedInUserID = userID;

        List<UserDTO> userList = userService.getAllUsersAdmin();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("users");

        return modelAndView;
    }

}
