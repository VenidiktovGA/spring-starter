package ru.venidiktov.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.venidiktov.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
