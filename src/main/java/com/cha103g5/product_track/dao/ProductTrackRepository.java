package com.cha103g5.product_track.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTrackRepository extends JpaRepository<ProductTrackVO, Integer> {
    // 修改方法以返回一個列表
    List<ProductTrackVO> findByProductNoAndMemberNo(int productNo, int memberNo);


}
