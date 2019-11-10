package com.chnic.demo.service;

import com.chnic.demo.BaseUnitTest;
import com.chnic.demo.entity.User;
import com.chnic.demo.exception.UserNotFoundException;
import com.chnic.demo.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

public class UserServiceTest extends BaseUnitTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void should_get_user_list_from_repository() {
        doReturn(Lists.newArrayList(
                User.builder().name("u1").build(),
                User.builder().name("u2").build()
        )).when(userRepository).findAll();

        List<User> userList = userService.getUserList();
        assertEquals(2, userList.size());
    }

    @Test
    public void should_return_exception_when_no_user_is_retrieved() throws Exception {
        doReturn(Optional.empty()).when(userRepository).findByName(any());
        assertThrows(UserNotFoundException.class, () -> userService.getUserByName("test_name"));
    }
}
