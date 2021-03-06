package ro.sd.a2.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicDTO {

    private String id;
    private String name;
    private List<ArtistDTO> artistList;
}
