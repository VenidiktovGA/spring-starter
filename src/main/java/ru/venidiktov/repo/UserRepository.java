package ru.venidiktov.repo;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import ru.venidiktov.dto.UserFIOInfo;
import ru.venidiktov.dto.UserInfo;
import ru.venidiktov.entity.Role;
import ru.venidiktov.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.firstName like %:firstName% and lastName like %:lastName%")
    List<User> findAllLikeBy(String firstName, String lastName);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update User u set u.role = :role where u.id in (:ids)")
    int updateRole(Role role, Long ...ids);

    Optional<User> findTopByOrderByIdDesc();


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "50"))
    List<User> findTop3ByBirthDateBefore(LocalDate birthDate, Sort sort);

    @EntityGraph(attributePaths = {"company"})
    @Query(value = "select u from User u",
            countQuery = "select count(distinct u.firstName) from User u"
    )
    Page<User> findAllBy(Pageable pageable);

    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);

    @Query(
            value = "SELECT first_name firstName, last_name lastName from users where company_id = :companyId",
            nativeQuery = true
    )
    List<UserFIOInfo> findAllFIOByCompanyId(Integer companyId);
}
