package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.UserProfile;
import ro.sd.a2.entity.UserTransaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<UserTransaction, String> {

    List<UserTransaction> findAllByUserProfileT(UserProfile userProfile);
}
