package com.example.hw_5.config;

import com.example.hw_5.entity.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
        Restaurant.class,
        H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class AppContextTest {

    @Test
    void contextLoads() {
    }
}