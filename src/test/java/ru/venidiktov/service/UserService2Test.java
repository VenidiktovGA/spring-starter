package ru.venidiktov.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.venidiktov.BaseTest;

class UserService2Test extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    void findById_successFind_ifUserByIdContains() {
        System.out.println("");
    }
}