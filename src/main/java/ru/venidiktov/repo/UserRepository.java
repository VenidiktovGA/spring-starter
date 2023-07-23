package ru.venidiktov.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.venidiktov.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
