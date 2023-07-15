package ru.venidiktov.service;

import jakarta.annotation.PostConstruct;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.venidiktov.entity.User;
import ru.venidiktov.listener.entity.AccessType;
import ru.venidiktov.listener.entity.EntityEvent;
import ru.venidiktov.repo.CrudRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ApplicationEventPublisher eventPublisher;
    private final CrudRepository<Integer, User> userRepository;

    public Optional<User> findById(Integer id) {
        var user = userRepository.findById(id);
        eventPublisher.publishEvent(new EntityEvent(user, AccessType.READ));
        return user;
    }

    @PostConstruct
    void init() {
        System.out.println("ТУУУУУУУУУУУУУУУУт!!");
    }
}
