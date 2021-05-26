package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.StageDTO;
import ro.sd.a2.Mappers.StageMapper;
import ro.sd.a2.entity.Stage;
import ro.sd.a2.repository.StageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StageService {
    @Autowired
    public final StageRepository stageRepository;

    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public List<StageDTO> getAll() {
        List<Stage> stages = stageRepository.findAll();
        List<StageDTO> stageDTOS = new ArrayList<>();

        for(Stage s: stages){
            stageDTOS.add(StageMapper.mapStageToTOR(s));
        }
        return stageDTOS;
    }
}
