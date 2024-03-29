package com.coupons.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Coupon {

    private String couponId;

    private LocalDate validFrom;

    private LocalDate validUntil;

    private double distance;

    private String city;
}
