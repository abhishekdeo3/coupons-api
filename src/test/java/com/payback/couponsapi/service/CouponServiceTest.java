package com.payback.couponsapi.service;

import com.payback.couponsapi.PaybackCouponsApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = PaybackCouponsApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"/data/sql/data.sql"})
@ActiveProfiles("test")
class CouponServiceTest {

    @Test
    void getCoupons() {


    }
}
