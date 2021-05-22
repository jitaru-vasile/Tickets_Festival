package ro.sd.a2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stage {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String location;

    @OneToOne(mappedBy = "stage")
    private Performance performance;
}
