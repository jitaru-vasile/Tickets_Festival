package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.entity.FestivalTicket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<FestivalTicket, String> {

    FestivalTicket getById(String id);
}
