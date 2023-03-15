package com.coupons.api.controller;

import com.coupons.api.model.CouponEntity;
import com.coupons.api.repository.CouponRepository;
import com.coupons.api.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = MemberCouponsController.class)
@Import({CouponService.class})
@ActiveProfiles({"test"})
@WithMockUser
class MemberCouponsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CouponRepository couponRepository;

    @Test
    void getAllValidMemberCoupons_returnAllValidCoupons() throws Exception {

        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponId("106");
        couponEntity.setValidFrom(LocalDate.parse("2023-01-01"));
        couponEntity.setValidUntil(LocalDate.parse("2023-03-31"));

        when(couponRepository.findAllByMemberId(any(), any())).thenReturn(List.of(couponEntity));

        mockMvc.perform(get("/member-coupons/{memberId}", 1))
                .andExpect(content()
                        .string("{\"couponList\":[{\"couponId\":\"106\",\"validFrom\":\"2023-01-01\"," +
                                "\"validUntil\":\"2023-03-31\",\"distance\":0.0,\"city\":null}]}"));
    }

    @Test
    void getAllValidMemberCoupons_returnAllNearByValidCoupons() throws Exception {

        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponId("106");
        couponEntity.setValidFrom(LocalDate.parse("2023-01-01"));
        couponEntity.setValidUntil(LocalDate.parse("2023-03-31"));
        couponEntity.setCity("Munich");
        couponEntity.setLatitude("48.137154");
        couponEntity.setLongitude("11.576124");

        when(couponRepository.findAllByMemberId(any(), any())).thenReturn(List.of(couponEntity));

        mockMvc.perform(get("/member-coupons/1?latitude=48.137154&longitude=11.576124"))
                .andExpect(content()
                        .string("{\"couponList\":[{\"couponId\":\"106\",\"validFrom\":\"2023-01-01\"," +
                                "\"validUntil\":\"2023-03-31\",\"distance\":0.0,\"city\":\"Munich\"}]}"));
    }
}
