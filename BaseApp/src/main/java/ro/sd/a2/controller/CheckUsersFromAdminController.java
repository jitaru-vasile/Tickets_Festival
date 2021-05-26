package ro.sd.a2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.service.UserService;

import java.util.List;

@Controller
@RequestMapping("admin")
public class CheckUsersFromAdminController {

    @Autowired
    private UserService userService;


    @GetMapping("users")
    public ModelAndView editProfileForm() {

        List<UserDTO> userList = userService.getAllUsersAdmin();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("admin/users");

        return modelAndView;
    }

}
