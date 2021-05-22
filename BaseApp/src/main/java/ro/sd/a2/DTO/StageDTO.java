package ro.sd.a2.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sd.a2.entity.Performance;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StageDTO {

    private String id;
    private String name;
    private String location;
    private PerformanceDTO performance;
}
