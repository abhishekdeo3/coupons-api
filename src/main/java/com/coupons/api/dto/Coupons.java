package com.coupons.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Coupons {

    List<Coupon> couponList;
}
