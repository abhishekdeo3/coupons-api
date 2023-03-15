package com.coupons.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "COUPON")
public class CouponEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COUPON_ID")
    private String couponId;

    @Column(name = "VALID_FROM")
    private LocalDate validFrom;

    @Column(name = "VALID_UNTIL")
    private LocalDate validUntil;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "CITY")
    private String city;

    @ManyToMany(mappedBy = "couponEntities",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Set<MemberEntity> memberEntities = new HashSet<>();

}
