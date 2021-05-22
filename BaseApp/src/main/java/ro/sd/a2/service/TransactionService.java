package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.TicketDTO;
import ro.sd.a2.DTO.TransactionDTO;
import ro.sd.a2.DTO.UserDTO;
import ro.sd.a2.Mappers.TicketMapper;
import ro.sd.a2.Mappers.TransactionMapper;
import ro.sd.a2.Mappers.UserMapper;
import ro.sd.a2.entity.FestivalTicket;
import ro.sd.a2.entity.UserProfile;
import ro.sd.a2.entity.UserTransaction;
import ro.sd.a2.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean saveTransaction(UserDTO loggedInUser, TicketDTO ticket){

        TransactionDTO transaction = TransactionDTO.builder().id(UUID.randomUUID().toString())
                .festivalTicket(TicketMapper.dtoToFestivalTicket(ticket))
                .noOfTickets(1)
                .userProfileT(UserMapper.mapDTOToUser(loggedInUser)).build();

        transactionRepository.save(TransactionMapper.dtoToUserTransaction(transaction));
        return true;
    }

    public List<TransactionDTO> getAll() {
        List<UserTransaction> userTransactions =transactionRepository.findAll();
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for(UserTransaction userTransaction:userTransactions){
            transactionDTOS.add(TransactionMapper.UserTransactionToDTO(userTransaction));
        }
        return transactionDTOS;
    }

    public List<TransactionDTO> getAllByIdUser(UserDTO userDTO) {
        UserProfile user = UserMapper.mapDTOToUser(userDTO);
        List<UserTransaction> userTransactions =transactionRepository.findAllByUserProfileT(user);
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for(UserTransaction userTransaction:userTransactions){
            transactionDTOS.add(TransactionMapper.UserTransactionToDTO(userTransaction));
        }
        return transactionDTOS;
    }

    public void remove(TransactionDTO transaction) {
        transactionRepository.delete(TransactionMapper.dtoToUserTransaction(transaction));
    }

    public void update(TransactionDTO transactionToUpdate, TicketDTO ticketDTO,int quantity) {
        UserTransaction transaction = transactionRepository.getOne(transactionToUpdate.getId());
        transaction.setFestivalTicket(TicketMapper.dtoToFestivalTicket(ticketDTO));
        transaction.setNoOfTickets(quantity);
        transactionRepository.save(transaction);

    }
}
