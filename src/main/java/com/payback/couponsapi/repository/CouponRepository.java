package com.payback.couponsapi.repository;

import com.payback.couponsapi.model.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CouponRepository extends JpaRepository<CouponEntity, String> {

    @Query(" SELECT couponEntity FROM CouponEntity couponEntity " +
            " JOIN FETCH couponEntity.memberEntities memberEntities " +
            " WHERE memberEntities.memberId = :memberId " +
            " AND couponEntity.validFrom <= :currentDate " +
            " AND couponEntity.validUntil >= :currentDate " +
            " ORDER BY couponEntity.validUntil DESC ")
    List<CouponEntity> findAllByMemberId(@Param("memberId") String memberId, @Param("currentDate") LocalDate currentDate);
}
