package com.its.member_20220729_01.repository;

import com.its.member_20220729_01.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
