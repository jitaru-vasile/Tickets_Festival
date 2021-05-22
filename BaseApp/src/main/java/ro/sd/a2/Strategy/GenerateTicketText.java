package ro.sd.a2.Strategy;

import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.DTO.UserDTO;

import java.io.File;
import java.io.FileWriter;

public class GenerateTicketText implements Strategy {
    @Override
    public String generateTicket(TicketDTO ticket, UserDTO user) {
        String ticketName = user.getFirstName()+user.getLastName()+"ticket.txt";
        try{
            File myTicket = new File(ticketName);
            if(myTicket.createNewFile()){
                FileWriter myWriter = new FileWriter(ticketName);
                myWriter.write("ticket name: " + ticket.getName() + "\n");
                myWriter.write("ticket price:" + ticket.getPrice() + "\n");
                myWriter.write("owner:" + user.getFirstName() + " " +user.getLastName() + "\n");

                myWriter.close();
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return ticketName;
    }
}
