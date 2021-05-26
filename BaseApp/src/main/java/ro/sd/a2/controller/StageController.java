package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.DTO.MusicDTO;
import ro.sd.a2.DTO.StageDTO;
import ro.sd.a2.service.MusicService;
import ro.sd.a2.service.StageService;

import java.util.List;

@Controller
@RequestMapping("admin")
public class StageController {
    private static final Logger log = LoggerFactory.getLogger(MusicController.class);

    @Autowired
    private StageService stageService;

    private List<StageDTO> stageDTOS;

    @GetMapping("stage")
    public ModelAndView loadArtistPage(){
        ModelAndView modelAndView = new ModelAndView("admin/Stages");
        stageDTOS = stageService.getAll();
        MusicDTO musicDTO = new MusicDTO();
        modelAndView.addObject("stages", stageDTOS);
        //modelAndView.addObject("musicDTO", musicDTO);
        return modelAndView;
    }
}
