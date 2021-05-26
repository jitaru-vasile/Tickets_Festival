package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.PerformanceDTO;
import ro.sd.a2.entity.PerformanceSchedule;

public class PerformanceMapper {
    public static PerformanceSchedule mapDTOToPerformance(PerformanceDTO performance) {
        return PerformanceSchedule.builder().id(performance.getId())
                .stage(StageMapper.mapDtoToStage(performance.getStage()))
                .startPerf(performance.getStart())
                .endPerf(performance.getEnd())
                .artist(ArtistMapper.mapDTOToArtist(performance.getArtist())).build();
    }

    public static PerformanceDTO mapPerformanceTDTo(PerformanceSchedule performanceSchedule) {
        return PerformanceDTO.builder().id(performanceSchedule.getId())
                .stage(StageMapper.mapStageToTOR(performanceSchedule.getStage()))
                .start(performanceSchedule.getStartPerf())
                .end(performanceSchedule.getEndPerf())
                .artist(ArtistMapper.mapArtistToDTO(performanceSchedule.getArtist())).build();
    }
}
