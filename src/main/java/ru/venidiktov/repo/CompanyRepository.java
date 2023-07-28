package ru.venidiktov.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.venidiktov.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByName(String name);
    List<Company> findByNameContainingIgnoreCase(String fragment);
}
