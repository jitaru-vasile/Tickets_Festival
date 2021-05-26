package ro.sd.a2.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import ro.sd.a2.entity.PerformanceSchedule;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {

    private String id;
    private String name;
    private List<PerformanceSchedule> performanceScheduleList;
    private MusicDTO musicType;


}
