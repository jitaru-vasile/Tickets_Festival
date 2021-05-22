package ro.sd.a2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicTypes {
    @Id
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "musicType")
    private List<Artist> artistList;
}
