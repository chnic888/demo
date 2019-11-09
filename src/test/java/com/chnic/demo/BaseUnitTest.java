package com.chnic.demo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("unit-test")
@ExtendWith(MockitoExtension.class)
public abstract class BaseUnitTest {
}
