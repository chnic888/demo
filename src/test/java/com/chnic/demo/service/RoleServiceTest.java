package com.chnic.demo.service;

import com.chnic.demo.BaseUnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class RoleServiceTest extends BaseUnitTest {

    @Spy
    private RoleService roleService;

    @Test
    public void test1() {
        assertEquals("Joe", roleService.getAdmin());
        assertEquals("Jess", roleService.getGuest());
    }

    @Test
    public void test2() {
        doReturn("Spy").when(roleService).getGuest();
        assertEquals("Joe", roleService.getAdmin());
        assertEquals("Spy", roleService.getGuest());
    }

    @Test
    public void test3() {
        when(roleService.getGuest()).thenReturn("Spy1");
        assertEquals("Joe", roleService.getAdmin());
        assertEquals("Spy1", roleService.getGuest());
    }
}
