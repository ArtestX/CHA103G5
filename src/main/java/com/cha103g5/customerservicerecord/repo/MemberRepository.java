package com.cha103g5.customerservicerecord.repo;

import com.cha103g5.member.model.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    public interface MemberRepository extends JpaRepository<MemberVO, Integer> {

        // 透過Email查詢會員的詳細資料
        public MemberVO findByMemberemail(String memberemail);
}
