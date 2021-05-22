package ro.sd.a2.Strategy;

import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.DTO.UserDTO;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy =strategy;
    }
    public String executeStrategy(TicketDTO ticket, UserDTO userDTO){
        return strategy.generateTicket(ticket,userDTO);
    }
}
