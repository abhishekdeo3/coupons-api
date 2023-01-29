package com.payback.couponsapi.service;

import com.payback.couponsapi.controller.converter.CouponEntityToCouponConverter;
import com.payback.couponsapi.dto.Coupon;
import com.payback.couponsapi.dto.Coupons;
import com.payback.couponsapi.model.CouponEntity;
import com.payback.couponsapi.repository.CouponRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Transactional(readOnly = true)
    public Coupons getCoupons(String memberId) {

        List<CouponEntity> couponEntities = couponRepository.findAllByMemberId(memberId, LocalDate.now());

        List<Coupon> couponList = couponEntities.stream().map(couponEntity -> {
            CouponEntityToCouponConverter couponEntityToCouponConverter = new CouponEntityToCouponConverter();
            return couponEntityToCouponConverter.convert(couponEntity);
        }).toList();

        return Coupons.builder()
                .couponList(couponList)
                .build();
    }

    public Coupons getNearByCoupons(String memberId, double latitude, double longitude) {

        List<CouponEntity> couponEntities = couponRepository.findAllByMemberId(memberId, LocalDate.now());

        List<Coupon> couponList = couponEntities.stream().map(couponEntity -> {

            double distance = distance(latitude, Double.parseDouble(couponEntity.getLatitude()), longitude,
                    Double.parseDouble(couponEntity.getLongitude()));

            CouponEntityToCouponConverter couponEntityToCouponConverter = new CouponEntityToCouponConverter();
            Coupon coupon = couponEntityToCouponConverter.convert(couponEntity);
            coupon.setDistance(Math.round(distance*100.0)/100.0);

            return coupon;

        }).sorted((Comparator.comparingDouble(Coupon::getDistance))).toList();

        return Coupons.builder()
                .couponList(couponList)
                .build();

    }

    private double distance(double currentLatitude, double couponLatitude, double currentLongitude, double couponLongitude) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(couponLatitude - currentLatitude);

        double lonDistance = Math.toRadians(couponLongitude - currentLongitude);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(currentLatitude)) * Math.cos(Math.toRadians(couponLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c;

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
}
