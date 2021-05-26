package ro.sd.a2.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.AddressDto;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.service.AddressService;
import ro.sd.a2.service.UserService;

@Controller
@RequestMapping("user")
public class EditProfileController {
    private static final Logger log = LoggerFactory.getLogger(EditProfileController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    private UserDTO loggedInUser;


    @GetMapping("editProfile")
    public ModelAndView editProfileForm() {

        ModelAndView modelAndView = new ModelAndView();
        String rePass ="";

        String currentUserName = "";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }

        loggedInUser = userService.getUserByEmail(currentUserName);
        modelAndView.addObject("password",rePass);
        modelAndView.addObject("userDto",loggedInUser);
        modelAndView.addObject("addressDto",loggedInUser.getAddressDto());
        modelAndView.setViewName("user/editProfile");

        return modelAndView;
    }

    @PostMapping(value = "editProfile", params = "action=update")
    public RedirectView update(@ModelAttribute("userDto") UserDTO userDTO, @ModelAttribute("addressDto") AddressDto addressDto){

        RedirectView redirectView = new RedirectView();
        try {
            addressDto.setId(loggedInUser.getAddressDto().getId());
            userDTO.setId(loggedInUser.getId());
            addressService.updateAddress(addressDto);
            userService.updateUser(userDTO);
            redirectView.setUrl("index");
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("editProfile");
        }
        return redirectView;
    }

    @PostMapping(value = "/editProfile", params = "action=cancel")
    public RedirectView cancel(){

        RedirectView redirectView = new RedirectView();
        try {
            redirectView.setUrl("index");
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("editProfile");
        }
        return redirectView;
    }





}
