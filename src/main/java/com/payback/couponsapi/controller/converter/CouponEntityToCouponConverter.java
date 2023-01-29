package com.payback.couponsapi.controller.converter;

import com.payback.couponsapi.dto.Coupon;
import com.payback.couponsapi.model.CouponEntity;

public class CouponEntityToCouponConverter {

    public Coupon convert(CouponEntity couponEntity) {

        return Coupon.builder()
                .couponId(couponEntity.getCouponId())
                .validFrom(couponEntity.getValidFrom())
                .validUntil(couponEntity.getValidUntil())
                .city(couponEntity.getCity())
                .build();
    }
}
