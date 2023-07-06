package ru.venidiktov.service;

import org.springframework.stereotype.Service;
import ru.venidiktov.entity.User;
import ru.venidiktov.repo.CrudRepository;

@Service
public class UserService {
    private final CrudRepository<Integer, User> userRepository;

    public UserService(CrudRepository userRepository) {
        this.userRepository = userRepository;
    }
}
