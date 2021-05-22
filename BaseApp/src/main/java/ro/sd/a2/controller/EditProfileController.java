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
import ro.sd.a2.service.AddressService;
import ro.sd.a2.service.UserService;

@Controller
public class EditProfileController {
    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    private String loggedInUserId;



    @GetMapping("/editProfile")
    public ModelAndView editProfileForm(@RequestParam(name="userId", required = true) String userId) {
        loggedInUserId = userId;
        ModelAndView modelAndView = new ModelAndView();
        String rePass ="";
        UserDTO loggedInUser = userService.getUserByID(userId);
        modelAndView.addObject("password",rePass);
        modelAndView.addObject("userDto",loggedInUser);
        modelAndView.addObject("addressDto",loggedInUser.getAddressDto());
        modelAndView.setViewName("editProfile");

        return modelAndView;
    }

    @PostMapping(value = "/editProfile", params = "action=update")
    public RedirectView update(@ModelAttribute("userDto") UserDTO userDTO, @ModelAttribute("addressDto") AddressDto addressDto){

        RedirectView redirectView = new RedirectView();
        try {
            addressDto.setId(userService.getUserByID(loggedInUserId).getAddressDto().getId());
            userDTO.setId(loggedInUserId);
            addressService.updateAddress(addressDto);
            userService.updateUser(userDTO);
            redirectView.setUrl("userMenu?userId="+loggedInUserId);
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("editProfile?userId="+loggedInUserId);
        }
        return redirectView;
    }

    @PostMapping(value = "/editProfile", params = "action=cancel")
    public RedirectView cancel(){

        RedirectView redirectView = new RedirectView();
        try {
            redirectView.setUrl("userMenu?userId="+loggedInUserId);
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("editProfile?userId="+loggedInUserId);
        }
        return redirectView;
    }





}
