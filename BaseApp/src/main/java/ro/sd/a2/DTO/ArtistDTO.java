package ro.sd.a2.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import ro.sd.a2.entity.Performance;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {

    private String id;
    private String name;
    private List<Performance> performanceList;
    private MusicDTO musicType;
}
