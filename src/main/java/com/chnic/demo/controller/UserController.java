package com.chnic.demo.controller;

import com.chnic.demo.dto.UserResponse;
import com.chnic.demo.service.UserService;
import com.chnic.demo.util.ModelMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author xxx
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/users")
@Api(value = "User API List")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(value = "List all users api", notes = "Return all the available users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getUserList() {
        return userService.getUserList().stream()
                .map(user -> ModelMapper.map(user, UserResponse.class))
                .collect(toList());
    }

    @GetMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name).stream()
                .map(user -> ModelMapper.map(user, UserResponse.class))
                .collect(toList());
    }

    @PostMapping(value = "/email-migration")
    @ResponseStatus(HttpStatus.CREATED)
    public List<UserResponse> migrateUserByEmail(@RequestBody List<String> emailList) {
        return userService.migrateUserByEmail(emailList).stream()
                .map(user -> ModelMapper.map(user, UserResponse.class))
                .collect(toList());
    }
}
