package com.company.barmanager.repository;

import com.company.barmanager.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(UserRepository.class)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void beforeEach() {

    }

    @Test
    void createUser() {
        User user = new User();
        user.setUsername("erik");
        user.setPassword("123");

        User createdUser = userRepository.save(user);
        userRepository.deleteById(createdUser.getId());

        Assertions.assertNotNull(createdUser);
    }

}