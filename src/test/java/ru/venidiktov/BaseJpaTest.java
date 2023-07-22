package ru.venidiktov;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ActiveProfiles;
import ru.venidiktov.repo.CompanyRepository;
import ru.venidiktov.repo.CrudRepository;

@SpringBootTest
@ActiveProfiles("test")
public class BaseJpaTest {
    @MockBean
    public ApplicationEventPublisher eventPublisher;

    @SpyBean
    public CrudRepository userRepository;

    @SpyBean
    public CompanyRepository companyRepository;
}
