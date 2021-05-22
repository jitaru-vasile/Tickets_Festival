package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.ArtistDTO;
import ro.sd.a2.entity.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistMapper {
    public static ArtistDTO mapArtistToDTO(Artist artist){
        return ArtistDTO.builder().id(artist.getId())
                .name(artist.getName())
                .performanceList(artist.getPerformanceList())
                .musicType(MusicMapper.mapMusicToDTO(artist.getMusicType())).build();
    }

    public static List<ArtistDTO> mapArtistToDTO(List<Artist> artists){
       List<ArtistDTO> artistList = new ArrayList<>();
       for(Artist a:artists){
           artistList.add(mapArtistToDTO(a));
       }
       return artistList;
    }

    public static Artist mapDTOToArtist(ArtistDTO artist){
        return Artist.builder().id(artist.getId())
                .name(artist.getName())
                .performanceList(artist.getPerformanceList())
                .musicType(MusicMapper.mapDTOToMusic(artist.getMusicType())).build();
    }

    public static List<Artist> mapDTOToArtist(List<ArtistDTO> artists){
        List<Artist> artistList = new ArrayList<>();
        for(ArtistDTO a:artists){
            artistList.add(mapDTOToArtist(a));
        }
        return artistList;
    }
}
