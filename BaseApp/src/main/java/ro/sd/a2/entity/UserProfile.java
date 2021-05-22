package ro.sd.a2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private LocalDate birthDate;

    @Column
    private boolean permission;

    @Column
    private String password;

    @OneToOne
    @JoinColumn(name="address_id")
    private  Address address;

    @OneToMany(mappedBy = "userProfileT", orphanRemoval = true)
    private Set<UserTransaction> userTransactions;

}
