package ru.venidiktov.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.venidiktov.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c " +
            "join fetch c.locales cl " +
            " where c.name = :name")
    Optional<Company> findByName(@Param("name") String name);
    List<Company> findByNameContainingIgnoreCase(String fragment);
}
