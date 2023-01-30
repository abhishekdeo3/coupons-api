package com.payback.couponsapi.service;

import com.payback.couponsapi.PaybackCouponsApiApplication;
import com.payback.couponsapi.dto.Coupons;
import com.payback.couponsapi.model.CouponEntity;
import com.payback.couponsapi.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = PaybackCouponsApiApplication.class)
@ActiveProfiles("test")
class CouponServiceTest {

    @MockBean
    private CouponRepository couponRepository;

    @Autowired
    CouponService couponService;

    @Test
    void getCoupons() {

        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponId("106");
        couponEntity.setValidFrom(LocalDate.parse("2023-01-01"));
        couponEntity.setValidUntil(LocalDate.parse("2023-03-31"));
        couponEntity.setCity("Munich");
        couponEntity.setLatitude("48.137154");
        couponEntity.setLongitude("11.576124");

        when(couponRepository.findAllByMemberId(any(), any())).thenReturn(List.of(couponEntity));

        Coupons coupons = couponService.getCoupons("1");

        assertThat(coupons.getCouponList()).hasSize(1);
        assertThat(coupons.getCouponList().get(0).getCouponId()).isEqualTo("106");
    }
}
