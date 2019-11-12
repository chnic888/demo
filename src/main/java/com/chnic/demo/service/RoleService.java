package com.chnic.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xxx
 */
@Slf4j
@Service
public class RoleService {

    public String getAdmin() {
        log.info("get admin role");
        return "Joe";
    }

    public String getGuest() {
        log.info("get guest role");
        return "Jess";
    }
}
