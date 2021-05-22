package ro.sd.a2.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sd.a2.entity.Artist;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceDTO {

    private String id;
    private LocalDateTime start;
    private LocalDateTime end;
    private ArtistDTO artist;
    private StageDTO stage;
}
