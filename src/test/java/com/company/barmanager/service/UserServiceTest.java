package com.company.barmanager.service;


import com.company.barmanager.exception.LoginException;
import com.company.barmanager.exception.UsernameTakenException;
import com.company.barmanager.model.User;
import com.company.barmanager.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(UserService.class)
class UserServiceTest {

    @Autowired
    UserService userService;



    @Test
    void verifyLogin() {
        // Arrange
        User t = new User();
        t.setUsername("a");
        t.setPassword("b");

        // Act

        // Assert
        Assertions.assertThrows(LoginException.class, () -> userService.verifyLogin(t));
    }

    @Test
    void createUser() throws UsernameTakenException {
        User user = new User();
        user.setUsername("erik");
        user.setPassword("123");

        User createdUser = userService.save(user);
        userService.deleteById(createdUser.getId());

        Assertions.assertNotNull(createdUser);
    }

    @Test
    void findAll() throws UsernameTakenException {
        //arrange
        User user = new User();
        user.setUsername("user1");
        user.setPassword("1");

        User user2 = new User();
        user.setUsername("user2");
        user.setPassword("2");

        //act
        userService.save(user);
        userService.save(user2);
        List<User> allUsers = userService.findAll();

        //assert
        Assertions.assertEquals(3, allUsers.size());
    }

    @Test
    void deleteById() throws UsernameTakenException {
        User user = new User();

        User saved = userService.save(user);

        userService.deleteById(saved.getId());

        Assertions.assertThrows(ChangeSetPersister.NotFoundException.class, () -> userService.findUserById(saved.getId()));
    }
}