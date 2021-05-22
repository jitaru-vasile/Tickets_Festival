package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.StageDTO;
import ro.sd.a2.entity.Stage;

public class StageMapper {
    public static Stage mapDtoToStage(StageDTO stage){
        return Stage.builder().id(stage.getId())
                .location(stage.getLocation())
                .name(stage.getName())
                .performance(PerformanceMapper.mapDTOToPerformance(stage.getPerformance())).build();

    }

    public static StageDTO mapStageToTOR(Stage stage){
        return StageDTO.builder().id(stage.getId())
                .location(stage.getLocation())
                .name(stage.getName())
                .performance(PerformanceMapper.mapPerformanceTDTo(stage.getPerformance())).build();

    }
}
