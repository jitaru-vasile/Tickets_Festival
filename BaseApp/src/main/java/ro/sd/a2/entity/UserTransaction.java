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
public class UserTransaction {
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserProfile userProfileT;

    @ManyToOne
    @JoinColumn(name="ticket_id")
    private FestivalTicket festivalTicket;

    @Column
    private Integer noOfTickets;


}
