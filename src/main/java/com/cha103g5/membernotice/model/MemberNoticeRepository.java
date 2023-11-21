package com.cha103g5.membernotice.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberNoticeRepository extends JpaRepository<MemberNoticeVO, Integer> {

}