package ro.sd.a2.Strategy;

import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.DTO.UserDTO;

public interface Strategy {
    public String generateTicket(TicketDTO ticket, UserDTO user);
}
