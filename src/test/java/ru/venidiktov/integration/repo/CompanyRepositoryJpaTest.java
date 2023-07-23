package ru.venidiktov.integration.repo;

import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import ru.venidiktov.BaseJpaTest;
import ru.venidiktov.entity.Company;

class CompanyRepositoryJpaTest extends BaseJpaTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    void findById() {
        //Ищем в БД Company с id = 1
        transactionTemplate.executeWithoutResult( tx -> {
            var company = entityManager.find(Company.class, 7);

            assertAll(
                    () -> assertThat(company).isNotNull(),
                    () -> assertThat(company.getLocales()).hasSize(2)
            );
        });
    }

//    @Test
//    @Transactional
//    @Commit
//    void save() {
//        var company = Company.builder()
//                .name("Apple")
//                .locales(Map.of(
//                        "ru", "Apple"
//                )).build();
//
//        entityManager.persist(company);
//    }
}