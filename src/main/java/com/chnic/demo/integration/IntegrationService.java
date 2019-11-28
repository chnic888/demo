package com.chnic.demo.integration;

import com.chnic.demo.entity.User;
import com.chnic.demo.util.RandomGeneratorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author xxx
 */
@Slf4j
@Service
public class IntegrationService {

    private static final String EMAIL_SUFFIX = "com";

    public User getUserByEmailFromExternalSystem(String email) {
        log.info("get user from external system by {}", email);

        User.UserBuilder userBuilder = User.builder()
                .name(RandomGeneratorUtil.generateName())
                .mobile(RandomGeneratorUtil.generateMobileNumber())
                .birthday(new Date())
                .email(email);

        if (email.endsWith(EMAIL_SUFFIX)) {
            userBuilder.gender(1);
        } else {
            userBuilder.gender(0);
        }

        return userBuilder.build();
    }
}
