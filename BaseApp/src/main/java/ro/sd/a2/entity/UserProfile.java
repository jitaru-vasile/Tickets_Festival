package ro.sd.a2.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile  {

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

    private String roles;

    private String permissions;

    private int active = 1;

    public List<String> getRolesList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }else
            return new ArrayList<>();
    }
    public List<String> getPermissionList(){
        if(this.permissions.length()>0){
            return Arrays.asList(this.roles.split(","));
        }else
            return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
