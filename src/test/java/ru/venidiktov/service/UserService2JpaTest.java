package ru.venidiktov.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.venidiktov.BaseJpaTest;

class UserService2JpaTest extends BaseJpaTest {

    @Autowired
    private UserService userService;

    @Test
    void findById_successFind_ifUserByIdContains() {
        System.out.println("");
    }
}