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
public class Artist {
    @Id
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<PerformanceSchedule> performanceScheduleList;

    @ManyToOne
    @JoinColumn(name = "musicTypes_id")
    private MusicTypes musicType;

}
