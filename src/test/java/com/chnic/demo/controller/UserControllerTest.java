package com.chnic.demo.controller;

import com.chnic.demo.BaseIntegrationTest;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author xxx
 */
public class UserControllerTest extends BaseIntegrationTest {

    @BeforeEach
    public void setUp() {
        System.out.println("##############BeforeEach##############");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("##############AfterEach##############");
    }

    @BeforeAll
    public static void BeforeAll() {
        System.out.println("##############BeforeAll##############");
    }

    @AfterAll
    public static void AfterAll() {
        System.out.println("##############AfterAll##############");
    }

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

    @Test
    public void testReturnMigratedUser() throws Exception {
        mockMvc.perform(post("/api/v1/users/email-migration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Lists.newArrayList("123@gmail.com", "456@gmail.cn"))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].email").value("123@gmail.com"))
                .andExpect(jsonPath("$[1].name").exists())
                .andExpect(jsonPath("$[1].email").value("456@gmail.cn"));
    }

    @Test
    @Sql({"classpath:sql/test_insert_users.sql"})
    public void testReturn4Users() throws Exception {
        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Disabled
    @Test
    public void testDisabledCase() throws Exception {
        assertTrue(false);
    }
}
