package ru.venidiktov.service;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ActiveProfiles;
import ru.venidiktov.entity.User;
import ru.venidiktov.listener.entity.EntityEvent;
import ru.venidiktov.repo.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @MockBean
    private ApplicationEventPublisher eventPublisher;

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void init() {
        userService = new UserService(eventPublisher, userRepository);
    }

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