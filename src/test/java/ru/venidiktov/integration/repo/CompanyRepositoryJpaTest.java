package ru.venidiktov.integration.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.venidiktov.BaseJpaTest;

class CompanyRepositoryJpaTest extends BaseJpaTest {

    @Test
    @Transactional
    void findById() {
        //Ищем в БД Company с id = 1
        var company = companyRepository.findById(7).get();

        assertAll(
                () -> assertThat(company).isNotNull(),
                () -> assertThat(company.getLocales()).hasSize(2)
        );
    }

    @Test
    void checkFindByQueries() {
        var company = companyRepository.findByName("Google").get();
        var companies = companyRepository.findByNameContainingIgnoreCase("goo");

        assertAll(
                () -> assertThat(company).isNotNull(),
                () -> assertThat(companies).isNotEmpty()
        );
    }
}