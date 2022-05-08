package com.company.barmanager.service;

import com.company.barmanager.exception.LoginException;
import com.company.barmanager.model.User;
import com.company.barmanager.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceTest {

    @Autowired
    UserService userService;



    @Test
    void verifyLogin() throws LoginException {
        // Arrange
        User t = new User();
        t.setUsername("a");
        t.setPassword("b");

        // Act

        // Assert
        Assertions.assertThrows(LoginException.class, () -> userService.verifyLogin(t));

    }
}