package com.chnic.demo.controller;

import com.chnic.demo.BaseIntegrationTest;
import com.chnic.demo.entity.User;
import com.chnic.demo.integration.IntegrationService;
import com.chnic.demo.util.RandomGeneratorUtil;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.Date;
import java.util.Random;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author xxx
 */
public class MockUserControllerTest extends BaseIntegrationTest {

    @MockBean
    private IntegrationService integrationService;

    @Test
    public void testReturnMigratedUserWithMockedIntegrationService() throws Exception {
        when(integrationService.getUserByEmailFromExternalSystem(any())).thenReturn(User.builder()
                .name("MockedUser")
                .gender(1)
                .birthday(new Date())
                .email("test@163.com")
                .mobile(RandomGeneratorUtil.generateMobileNumber())
                .build());

        mockMvc.perform(post("/api/v1/users/email-migration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Lists.newArrayList("123@gmail.com"))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("MockedUser"))
                .andExpect(jsonPath("$[0].email").value("test@163.com"))
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }
}
