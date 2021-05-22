package ro.sd.a2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.Exception.NullFieldException;
import ro.sd.a2.Mappers.TicketMapper;
import ro.sd.a2.controller.FirstController;
import ro.sd.a2.entity.FestivalTicket;
import ro.sd.a2.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private final TicketRepository ticketRepository;

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Boolean insert(TicketDTO ticketDTO){
        ticketRepository.save(TicketMapper.dtoToFestivalTicket(ticketDTO));
        return true;
    }

    public List<TicketDTO> getAllTickets() {
        List<FestivalTicket> tickets = ticketRepository.findAll();
        List<TicketDTO> ticketDTOS = new ArrayList<>();
        for(FestivalTicket f:tickets){
            ticketDTOS.add(TicketMapper.festivalTicketToDTO(f));
        }
        return ticketDTOS;
    }

    public TicketDTO getTicketById(String ticketId) {
        if(ticketId == null){
            throw  new NullFieldException("Id is null!");
        }
        return TicketMapper.festivalTicketToDTO(ticketRepository.getById(ticketId));
    }

    public void delete(String ticketId){
        if(ticketId == null){
            throw  new NullFieldException("Id is null!");
        }
        ticketRepository.deleteById(ticketId);
    }

    public void update(TicketDTO ticketDTO) {
        FestivalTicket ticketToUpdate= ticketRepository.getOne(ticketDTO.getId());
        if(ticketDTO.getStartDate() == null){
            log.info("Start date not given");
        }else{
            ticketToUpdate.setStartDate(ticketDTO.getStartDate());
        }
        if(ticketDTO.getEndDate() == null){
            log.info("End date not given");
        }else {
            ticketToUpdate.setEndDate(ticketDTO.getEndDate());
        }
        if(ticketDTO.getPrice() == 0){
            log.info("Price not given");
        }else {
            ticketToUpdate.setPrice(ticketDTO.getPrice());
        }
        if(ticketDTO.getName() == null){
            log.info("Name not given");
        }else{
            ticketToUpdate.setName(ticketDTO.getName());
        }
        ticketRepository.save(ticketToUpdate);
    }
}
