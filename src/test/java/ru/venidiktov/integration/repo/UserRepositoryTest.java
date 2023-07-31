package ru.venidiktov.integration.repo;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ru.venidiktov.BaseJpaTest;
import ru.venidiktov.entity.Company;
import ru.venidiktov.entity.Role;
import ru.venidiktov.entity.User;

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

    @Test
    void checkFirstTop() {
        var topUser = userRepository.findTopByOrderByIdDesc();

        assertThat(topUser).isPresent();
    }

    @Test
    @Transactional
    void findTop3ByBirthDateBefore() {
        var sort = Sort.sort(User.class);
        sort.by(User::getFirstName).and(sort.by(User::getLastName));

        var allUsers = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);

        assertThat(allUsers).hasSize(3);
    }

    @Test
    void checkPageable() {
        var sort = Sort.sort(User.class).by(User::getId);
        var pageable = PageRequest.of(1, 2, sort);

        var slice = userRepository.findAllBy(pageable);
        assertThat(slice).hasSize(2);

        if(slice.hasNext()) {
            var slice2 = userRepository.findAllBy(slice.nextPageable());
            assertThat(slice2).hasSize(1);
        }
    }

    @Test
    void checkEntityGraph() {
        var sort = Sort.sort(User.class).by(User::getId);
        var pageable = PageRequest.of(1, 2, sort);

        var slice = userRepository.findAllBy(pageable);
        assertThat(slice.getContent().get(0).getCompany().getName()).isNotNull();
    }
}