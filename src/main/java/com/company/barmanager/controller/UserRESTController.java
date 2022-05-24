package com.company.barmanager.controller;

import com.company.barmanager.exception.LoginException;
import com.company.barmanager.exception.UsernameTakenException;
import com.company.barmanager.model.User;
import com.company.barmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserRESTController {

    private final UserService userService;

    @Autowired
    public UserRESTController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) throws UsernameTakenException {
        System.out.println(user);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/verify")
    public ResponseEntity<User> verifyLogin(@RequestBody User user) throws LoginException {
        User userVerified = userService.verifyLogin(user);
        return new ResponseEntity<>(userVerified, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
