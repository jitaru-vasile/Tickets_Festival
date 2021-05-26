package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.ArtistDTO;
import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.service.ArtistService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("admin")
public class ArtistController {
    private static final Logger log = LoggerFactory.getLogger(ArtistController.class);

    private List<ArtistDTO> artists;

    @Autowired
    private ArtistService artistService;

    @GetMapping("artists")
    public ModelAndView loadArtistPage(){
        ModelAndView modelAndView = new ModelAndView("admin/ArtistsAdmin");
        artists = artistService.getAllArtists();
        ArtistDTO artistDTO = new ArtistDTO();
        modelAndView.addObject("artists", artists);
        modelAndView.addObject("artistDTO", artistDTO);
        return modelAndView;
    }

    @PostMapping(value = "artists/add", params = "action=add")
    public RedirectView addArtist(@ModelAttribute("artistDTO") ArtistDTO artistDTO){
        RedirectView redirectView = new RedirectView();
        try {

            artistDTO.setId(UUID.randomUUID().toString());
            log.error(artistDTO.toString());
            artistService.insert(artistDTO);
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/artists");
        }
        return redirectView;
    }

}
