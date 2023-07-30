package ru.venidiktov.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    Optional<User> findTopByOrderByIdDesc();

    List<User> findTop3ByBirthDateBefore(LocalDate birthDate, Sort sort);

    List<User> findAllBy(Pageable pageable);
}
