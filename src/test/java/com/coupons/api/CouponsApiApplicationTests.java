package com.coupons.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = CouponsApiApplication.class)
@ActiveProfiles("test")
class CouponsApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
