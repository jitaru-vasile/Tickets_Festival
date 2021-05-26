package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.MusicDTO;
import ro.sd.a2.entity.MusicTypes;

public class MusicMapper {
    public static MusicDTO mapMusicToDTO(MusicTypes musicType) {
        return MusicDTO.builder().id(musicType.getId())
                .name(musicType.getName())
                .artistList(ArtistMapper.mapArtistToDTO(musicType.getArtistList()))
                .build();
    }

    public static MusicTypes mapDTOToMusic(MusicDTO musicType) {
        return MusicTypes.builder().id(musicType.getId())
                .name(musicType.getName())
                //.artistList(ArtistMapper.mapDTOToArtist(musicType.getArtistList()))
                .build();
    }
}
