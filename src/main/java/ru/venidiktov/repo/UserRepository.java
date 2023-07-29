package ru.venidiktov.repo;

import jakarta.persistence.NamedQuery;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.venidiktov.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User where u.firstName like %:firstName% and lastName like %:lastName%")
    List<User> findAllLikeBy(String firstName, String lastName);
}
