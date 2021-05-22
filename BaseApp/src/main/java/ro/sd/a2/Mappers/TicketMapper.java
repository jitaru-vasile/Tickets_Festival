package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.entity.FestivalTicket;

public class TicketMapper {

    public static TicketDTO festivalTicketToDTO(FestivalTicket festivalTicket){
        return TicketDTO.builder().id(festivalTicket.getId())
                .name(festivalTicket.getName())
                .type(festivalTicket.getName())
                .startDate(festivalTicket.getStartDate())
                .endDate(festivalTicket.getEndDate())
                .price(festivalTicket.getPrice())
                .userTransactions(festivalTicket.getUserTransactions()).build();

    }

    public static FestivalTicket dtoToFestivalTicket(TicketDTO ticketDTO){
        return FestivalTicket.builder().id(ticketDTO.getId())
                .name(ticketDTO.getName())
                .type(ticketDTO.getName())
                .startDate(ticketDTO.getStartDate())
                .endDate(ticketDTO.getEndDate())
                .price(ticketDTO.getPrice())
                .userTransactions(ticketDTO.getUserTransactions()).build();

    }
}
