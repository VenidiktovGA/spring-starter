package ru.venidiktov.service;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import ru.venidiktov.entity.User;
import ru.venidiktov.listener.entity.EntityEvent;
import ru.venidiktov.repo.CrudRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Mock
    private CrudRepository<Integer, User> userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void findById_successFind_ifUserByIdContains() {
        var userId = 3;
        doReturn(Optional.of(new User(userId))).when(userRepository).findById(userId);

        var userOptional = userService.findById(userId);

        verify(eventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(eventPublisher);
        assertAll(
                () -> assertTrue(userOptional.isPresent()),
                () -> assertThat(userOptional.get().id()).isEqualTo(userId)
        );
    }
}