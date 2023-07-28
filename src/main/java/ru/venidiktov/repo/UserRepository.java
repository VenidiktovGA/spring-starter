package ru.venidiktov.repo;

import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.venidiktov.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
