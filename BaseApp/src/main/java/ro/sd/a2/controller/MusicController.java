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
import ro.sd.a2.DTO.MusicDTO;
import ro.sd.a2.service.ArtistService;
import ro.sd.a2.service.MusicService;

import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping("admin")
public class MusicController {
    private static final Logger log = LoggerFactory.getLogger(MusicController.class);

    private List<MusicDTO> musicDTOS;

    @Autowired
    private MusicService musicService;

    @GetMapping("music")
    public ModelAndView loadArtistPage(){
        ModelAndView modelAndView = new ModelAndView("admin/MusicAdmin");
        musicDTOS = musicService.getAll();
        MusicDTO musicDTO = new MusicDTO();
        modelAndView.addObject("musics", musicDTOS);
        modelAndView.addObject("musicDTO", musicDTO);
        return modelAndView;
    }

    @PostMapping(value = "music/add", params = "action=add")
    public RedirectView addArtist(@ModelAttribute("musicDTO") MusicDTO musicDTO){
        RedirectView redirectView = new RedirectView();
        try {

            musicDTO.setId(UUID.randomUUID().toString());
            log.error(musicDTO.toString());
            musicService.save(musicDTO);
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }catch (Exception e){
            log.error(e.getMessage());
            redirectView.setUrl("http://localhost:7799/app/admin/music");
        }
        return redirectView;
    }
}
