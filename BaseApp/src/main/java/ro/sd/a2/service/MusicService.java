package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.MusicDTO;
import ro.sd.a2.Mappers.MusicMapper;
import ro.sd.a2.entity.MusicTypes;
import ro.sd.a2.repository.MusicRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {

    @Autowired
    public final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<MusicDTO> getAll() {
        List<MusicDTO> musicDTOS = new ArrayList<>();
        List<MusicTypes> musicTypes = musicRepository.findAll();
        for(MusicTypes musicType:musicTypes){
            musicDTOS.add(MusicMapper.mapMusicToDTO(musicType));
        }
        return musicDTOS;
    }

    public void save(MusicDTO musicDTO) {
        musicRepository.save(MusicMapper.mapDTOToMusic(musicDTO));
    }
}
