package com.chnic.demo.service;

import com.chnic.demo.entity.User;
import com.chnic.demo.exception.UserNotFoundException;
import com.chnic.demo.integration.IntegrationService;
import com.chnic.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author xxx
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    private final IntegrationService integrationService;

    @Autowired
    public UserService(UserRepository userRepository, IntegrationService integrationService) {
        this.userRepository = userRepository;
        this.integrationService = integrationService;
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    public List<User> migrateUserByEmail(List<String> emailList) {
        return userRepository.saveAll(emailList.stream()
                .map(integrationService::getUserByEmailFromExternalSystem)
                .collect(toList()));
    }
}
