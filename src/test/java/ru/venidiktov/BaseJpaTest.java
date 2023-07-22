package ru.venidiktov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import ru.venidiktov.repo.CompanyRepository;
import ru.venidiktov.repo.CrudRepository;
import ru.venidiktov.service.UserService;

@SpringBootTest
@ActiveProfiles("test")
@Import(TestConfig.class)
public class BaseJpaTest {

    @Autowired
    protected ApplicationEventPublisher applicationEventPublisher;

    @SpyBean
    protected CrudRepository userRepository;

    @SpyBean
    protected CompanyRepository companyRepository;

    @SpyBean
    protected UserService userService;
}
