package ro.sd.a2.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.UserProfile;

import javax.validation.constraints.Email;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, String> {
    UserProfile findByEmail(String email);

    UserProfile getUserProfileByEmailAndPassword(String email, String password);

    UserProfile getUserProfileById(String id);

}
