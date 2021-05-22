package ro.sd.a2.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sd.a2.entity.FestivalTicket;
import ro.sd.a2.entity.UserProfile;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private String id;
    private UserProfile userProfileT;
    private FestivalTicket festivalTicket;
    private Integer noOfTickets;

}
