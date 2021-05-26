package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.AddressDto;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.service.AddressService;
import ro.sd.a2.service.UserService;

import java.util.Arrays;
import java.util.UUID;

@Controller
public class SignInController {
    private static final Logger log = LoggerFactory.getLogger(SignInController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/signIn")
    public ModelAndView signInForm() {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO userDTO = new UserDTO();
        AddressDto addressDto = new AddressDto();
        String rePassword = "";
        String houseHoldNumber= "";
        String street = "";;
        String city = "";
        String apartment = "";
        String building = "";
        String floor = "";

        modelAndView.addObject("userDto",userDTO);
        modelAndView.addObject("addressDto", addressDto);
        modelAndView.addObject("rePass",rePassword);
        modelAndView.addObject("houseHoldNumber",houseHoldNumber);
        modelAndView.addObject("street",street);
        modelAndView.addObject("city",city);
        modelAndView.addObject("apartment",apartment);
        modelAndView.addObject("building",building);
        modelAndView.addObject("floor",floor);


        modelAndView.setViewName("signIn");

        return modelAndView;
    }

    @PostMapping(value = "/signIn", params = "action=signIn")
    public RedirectView signIn(@ModelAttribute("userDto") UserDTO userDTO, @ModelAttribute("addressDto") AddressDto addressDto){
        RedirectView redirectView = new RedirectView();
        try{
        //restTemplate.postForObject("http://localhost:7798/email", userDTO, UserDTO.class);
        userDTO.setId(UUID.randomUUID().toString());
        addressDto.setId(UUID.randomUUID().toString());
        userDTO.setAddressDto(addressDto);
        addressService.saveAddress(addressDto);
        userService.saveUser(userDTO);
        redirectView.setUrl("http://localhost:7799/app/logIn");
        }
        catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            redirectView.setUrl("http://localhost:7799/app/signIn");
        }
        return redirectView;
    }

}
