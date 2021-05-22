package ro.sd.a2.Mappers;

import ro.sd.a2.DTO.TransactionDTO;
import ro.sd.a2.entity.UserTransaction;

public class TransactionMapper {

    public static UserTransaction dtoToUserTransaction(TransactionDTO transactionDTO){
        return UserTransaction.builder().id(transactionDTO.getId())
                .userProfileT(transactionDTO.getUserProfileT())
                .festivalTicket(transactionDTO.getFestivalTicket())
                .noOfTickets(transactionDTO.getNoOfTickets()).build();
    }

    public static TransactionDTO UserTransactionToDTO(UserTransaction userTransaction){
        return TransactionDTO.builder().id(userTransaction.getId())
                .userProfileT(userTransaction.getUserProfileT())
                .festivalTicket(userTransaction.getFestivalTicket())
                .noOfTickets(userTransaction.getNoOfTickets()).build();
    }
}


