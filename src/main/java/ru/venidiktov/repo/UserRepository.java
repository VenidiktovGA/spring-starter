package ru.venidiktov.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.venidiktov.entity.Role;
import ru.venidiktov.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.firstName like %:firstName% and lastName like %:lastName%")
    List<User> findAllLikeBy(String firstName, String lastName);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update User u set u.role = :role where u.id in (:ids)")
    int updateRole(Role role, Long ...ids);
}
