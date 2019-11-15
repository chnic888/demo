package com.chnic.demo.controller;

import com.chnic.demo.BaseIntegrationTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author xxx
 */
public class UserControllerTest extends BaseIntegrationTest {

    @Test
    public void testReturnAllAvailableUsers() throws Exception {
        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testReturnUserNotFoundExceptionWhenRetrievedNonexistentName() throws Exception {
        mockMvc.perform(get("/api/v1/users/test-user-name"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testReturnUserWhenSearchExistedName() throws Exception {
        mockMvc.perform(get("/api/v1/users/Lionel Messi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
