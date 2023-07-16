package ru.venidiktov;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ActiveProfiles;
import ru.venidiktov.repo.CrudRepository;

@SpringBootTest
@ActiveProfiles("test")
public class BaseTest {

    @MockBean
    public ApplicationEventPublisher eventPublisher;

    @SpyBean
    public CrudRepository userRepository;
}
