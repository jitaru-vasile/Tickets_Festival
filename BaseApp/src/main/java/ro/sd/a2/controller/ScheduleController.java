package ro.sd.a2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.sd.a2.DTO.ArtistDTO;
import ro.sd.a2.DTO.PerformanceDTO;
import ro.sd.a2.DTO.StageDTO;
import ro.sd.a2.entity.Artist;
import ro.sd.a2.entity.Stage;
import ro.sd.a2.service.ArtistService;
import ro.sd.a2.service.PerformanceService;
import ro.sd.a2.service.StageService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
public class ScheduleController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private StageService stageService;

    @Autowired
    private PerformanceService performanceService;

    private List<ArtistDTO> artistDTOList;
    private List<PerformanceDTO> performanceDTOS;
    private List<StageDTO> stageDTOS;


    @GetMapping("admin/editSchedule")
    public ModelAndView editSchedule(){
        ModelAndView modelAndView = new ModelAndView("admin/schedule");

        artistDTOList = artistService.getAllArtists();
        performanceDTOS = performanceService.getAllPerformances();
        stageDTOS = stageService.getAll();

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now();


        modelAndView.addObject("artists",artistDTOList);
        modelAndView.addObject("stages",stageDTOS);
        modelAndView.addObject("performances",performanceDTOS);
        modelAndView.addObject("start",start);
        modelAndView.addObject("end",end);

        return modelAndView;
    }

    @GetMapping("schedule")
    public ModelAndView showSchedule(){
        ModelAndView modelAndView = new ModelAndView("schedule");
        performanceDTOS = performanceService.getAllPerformances();
        modelAndView.addObject("performances",performanceDTOS);

        return modelAndView;
    }

    @PostMapping(value = "admin/editSchedule/add")
    public RedirectView addPerformance(@Valid int artistSelected,
                                       @Valid int stageSelected,
                                       @RequestParam(value = "start", required = false) String startStr,
                                       @RequestParam(value = "end", required = false) String endStr){
        RedirectView redirectView = new RedirectView();
        try{
            LocalDateTime start = LocalDateTime.parse(startStr);
            LocalDateTime end = LocalDateTime.parse(endStr);
            System.err.println( artistDTOList.get(artistSelected).getName());
            System.err.println( stageDTOS.get(stageSelected).getName());
            System.err.println( start);
            System.err.println( end);
            PerformanceDTO performance = PerformanceDTO.builder().artist(artistDTOList.get(artistSelected))
                    .stage(stageDTOS.get(stageSelected))
                    .end(end)
                    .start(start)
                    .id(UUID.randomUUID().toString())
                    .build();
            performanceService.save(performance);
            redirectView.setUrl("http://localhost:7799/app/admin/index");
        }catch (Exception e){
            redirectView.setUrl("http://localhost:7799/app/admin/editSchedule");
        }
        return redirectView;
    }


}
