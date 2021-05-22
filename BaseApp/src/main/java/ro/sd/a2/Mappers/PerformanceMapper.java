package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.PerformanceDTO;
import ro.sd.a2.entity.Performance;

public class PerformanceMapper {
    public static Performance mapDTOToPerformance(PerformanceDTO performance) {
        return Performance.builder().id(performance.getId())
                .stage(StageMapper.mapDtoToStage(performance.getStage()))
                .start(performance.getStart())
                .end(performance.getEnd())
                .artist(ArtistMapper.mapDTOToArtist(performance.getArtist())).build();
    }

    public static PerformanceDTO mapPerformanceTDTo(Performance performance) {
        return PerformanceDTO.builder().id(performance.getId())
                .stage(StageMapper.mapStageToTOR(performance.getStage()))
                .start(performance.getStart())
                .end(performance.getEnd())
                .artist(ArtistMapper.mapArtistToDTO(performance.getArtist())).build();
    }
}
