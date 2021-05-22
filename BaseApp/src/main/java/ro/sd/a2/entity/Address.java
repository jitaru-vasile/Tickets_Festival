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
public class Address {
    @Id
    private String id;

    @Column
    private String houseHoldNumber;

    @Column
    private String street;

    @Column
    private  String city;

    @Column
    private String apartment;

    @Column
    private String building;

    @Column
    private String floor;

    @OneToOne(mappedBy = "address")
    private UserProfile userProfileM;



}
