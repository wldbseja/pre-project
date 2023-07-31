package spring.server.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.server.user.entity.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String email);

    @Query(value = "select u from User u join fetch u.questions q where u.userId = :userId")
    Optional<User> findUserFetch(Long userId);


}
