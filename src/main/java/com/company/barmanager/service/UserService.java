package com.company.barmanager.service;

import com.company.barmanager.controller.UserRESTController;
import com.company.barmanager.exception.LoginException;
import com.company.barmanager.exception.UsernameTakenException;
import com.company.barmanager.model.User;
import com.company.barmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) throws UsernameTakenException {
        if(!usernameTaken(user.getUsername())) {
            return userRepository.save(user);
        }else{
            throw new UsernameTakenException("Username taken");
        }
    }

    public Boolean usernameTaken(String username){
        return userRepository.usernameTaken(username) != null;
    }

    public User verifyLogin(User user) throws LoginException {
        return userRepository.findByUsernamePasswordMatch(user.getUsername(), user.getPassword())
                .orElseThrow(() -> new LoginException("User not found"));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
