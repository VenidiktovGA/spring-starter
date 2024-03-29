package ru.venidiktov.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.venidiktov.entity.User;
import ru.venidiktov.listener.entity.AccessType;
import ru.venidiktov.listener.entity.EntityEvent;
import ru.venidiktov.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ApplicationEventPublisher eventPublisher;
    private final UserRepository userRepository;

    @Transactional
    public Optional<User> findById(Long id) {
        var user = userRepository.findById(id);
        eventPublisher.publishEvent(new EntityEvent(user, AccessType.READ));
        return user;
    }
}
