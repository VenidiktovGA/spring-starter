package ru.venidiktov.service;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import ru.venidiktov.BaseJpaTest;
import ru.venidiktov.entity.User;
import ru.venidiktov.listener.entity.EntityEvent;

class UserServiceJpaTest extends BaseJpaTest {
    @Test
    void findById_successFind_ifUserByIdContains() {
        var userId = 3L;
        when(userRepository.findById(userId)).thenReturn(Optional.of(User.builder().id(userId).build()));

        var userOptional = userService.findById(userId);

        verify(applicationEventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(applicationEventPublisher);
        assertAll(
                () -> assertTrue(userOptional.isPresent()),
                () -> assertThat(userOptional.get().getId()).isEqualTo(userId)
        );
    }
}