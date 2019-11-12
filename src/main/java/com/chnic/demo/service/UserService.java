package com.chnic.demo.service;

import com.chnic.demo.entity.User;
import com.chnic.demo.exception.UserNotFoundException;
import com.chnic.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxx
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new UserNotFoundException("user not found"));
    }
}
