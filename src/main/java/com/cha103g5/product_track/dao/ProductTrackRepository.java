package com.cha103g5.product_track.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductTrackRepository extends JpaRepository<ProductTrackVO, Integer> {
    // 修改方法以返回一個列表
    List<ProductTrackVO> findByProductNoAndMemberNo(int productNo, int memberNo);

    // 在 ProductTrackRepository 中添加
    List<ProductTrackVO> findByMemberNo(int memberNo);


}
