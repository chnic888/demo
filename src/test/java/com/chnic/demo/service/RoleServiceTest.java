package com.chnic.demo.service;

import com.chnic.demo.BaseUnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * @author xxx
 */
public class RoleServiceTest extends BaseUnitTest {

    @Spy
    private RoleService roleService;

    @Test
    public void testNoSpy() {
        assertEquals("Joe", roleService.getAdmin());
        assertEquals("Jess", roleService.getGuest());
    }

    @Test
    public void testSpyEntireMethod() {
        doReturn("Spy").when(roleService).getGuest();
        assertEquals("Joe", roleService.getAdmin());
        assertEquals("Spy", roleService.getGuest());
    }

    @Test
    public void testSpyReturnValueOnly() {
        when(roleService.getGuest()).thenReturn("Spy1");
        assertEquals("Joe", roleService.getAdmin());
        assertEquals("Spy1", roleService.getGuest());
    }
}
