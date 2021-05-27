package ro.sd.a2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.PerformanceDTO;
import ro.sd.a2.Mappers.PerformanceMapper;
import ro.sd.a2.entity.Artist;
import ro.sd.a2.entity.PerformanceSchedule;
import ro.sd.a2.entity.Stage;
import ro.sd.a2.repository.ArtistRepository;
import ro.sd.a2.repository.PerformanceRepository;
import ro.sd.a2.repository.StageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    public final PerformanceRepository performanceRepository;

    @Autowired
    public final StageRepository stageRepository;

    @Autowired
    public final ArtistRepository artistRepository;


    public PerformanceService(PerformanceRepository performanceRepository, StageRepository stageRepository, ArtistRepository artistRepository) {
        this.performanceRepository = performanceRepository;
        this.stageRepository = stageRepository;
        this.artistRepository = artistRepository;
    }

    public List<PerformanceDTO> getAllPerformances() {
        List<PerformanceDTO> performanceDTOS = new ArrayList<>();
        List<PerformanceSchedule> performanceServices = performanceRepository.findAll();
        for(PerformanceSchedule p:performanceServices){
            performanceDTOS.add(PerformanceMapper.mapPerformanceTDTo(p));
        }
        return performanceDTOS;
    }

    public void save(PerformanceDTO performance) {
        Artist artist = artistRepository.getOne(performance.getArtist().getId());
        Stage stage = stageRepository.getOne(performance.getStage().getId());
        PerformanceSchedule performanceSchedule = PerformanceMapper.mapDTOToPerformance(performance);
        performanceSchedule.setArtist(artist);
        performanceSchedule.setStage(stage);
        performanceRepository.save(performanceSchedule);
    }
}
