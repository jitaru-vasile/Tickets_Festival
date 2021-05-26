package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.ArtistDTO;
import ro.sd.a2.Mappers.ArtistMapper;
import ro.sd.a2.entity.Artist;
import ro.sd.a2.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {
    @Autowired
    public final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<ArtistDTO> getAllArtists() {
        List<Artist> artists = artistRepository.findAll();
        List<ArtistDTO> artistDTOS = ArtistMapper.mapArtistToDTO(artists);
        return artistDTOS;
    }

    public void insert(ArtistDTO artistDTO) {
        Artist a = ArtistMapper.mapDTOToArtist(artistDTO);
        artistRepository.save(a);

    }
}
