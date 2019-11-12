package com.chnic.demo;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xxx
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        registerMDC();
        SpringApplication.run(DemoApplication.class, args);
    }

    private static void registerMDC() {
        MDC.put("user_name", "SYSTEM");
        MDC.put("session_id", "SESSION");
    }
}
