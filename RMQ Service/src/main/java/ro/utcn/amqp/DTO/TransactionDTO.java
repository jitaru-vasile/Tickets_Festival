package ro.utcn.amqp.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private String id;
    private UserDTO userProfileT;
    private TicketDTO festivalTicket;
    private Integer noOfTickets;

}
