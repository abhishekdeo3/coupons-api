package com.coupons.api.controller.converter;

import com.coupons.api.dto.Coupon;
import com.coupons.api.model.CouponEntity;

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
