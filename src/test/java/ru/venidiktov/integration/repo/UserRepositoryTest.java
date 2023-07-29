package ru.venidiktov.integration.repo;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.venidiktov.BaseJpaTest;
import ru.venidiktov.entity.Role;

class UserRepositoryTest extends BaseJpaTest {

    @Test
    @Transactional
    void checkUpdate() {
        var ivan = userRepository.findById(11L).get();
        assertSame(Role.ADMIN, ivan.getRole());
        ivan.setBirthDate(LocalDate.now());

        var resultCount = userRepository.updateRole(Role.USER, 11L, 15L);
        assertThat(resultCount).isEqualTo(2);

        var theSameIvan = userRepository.findById(11L).get();
        assertSame(Role.USER, theSameIvan.getRole());
    }

}