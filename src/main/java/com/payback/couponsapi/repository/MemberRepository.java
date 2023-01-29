package com.payback.couponsapi.repository;

import com.payback.couponsapi.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
}
