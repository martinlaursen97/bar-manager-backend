package com.company.barmanager.service;

import com.company.barmanager.controller.UserRESTController;
import com.company.barmanager.exception.LoginException;
import com.company.barmanager.model.User;
import com.company.barmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User verifyLogin(User user) throws LoginException {
        return userRepository.findByUsernamePasswordMatch(user.getUsername(), user.getPassword())
                .orElseThrow(() -> new LoginException("User not found"));
    }
}
