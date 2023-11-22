package com.cha103g5.product_track.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cha103g5.product_track.dao.ProductTrackRepository;
import com.cha103g5.product_track.dao.ProductTrackVO;

@Service
public class ProductTrackService {

    @Autowired
    private ProductTrackRepository productTrackRepository;

    // 查詢所有商品追蹤清單
    public List<ProductTrackVO> findAll() {
        return productTrackRepository.findAll();
    }

    // 根據ID查詢商品追蹤
    public Optional<ProductTrackVO> findById(int trackNo) {
        return productTrackRepository.findById(trackNo);
    }

    // 添加商品到追蹤清單
    public ProductTrackVO save(ProductTrackVO productTrackVO) {
        return productTrackRepository.save(productTrackVO);
    }

    // 更新商品追蹤資訊
    public ProductTrackVO update(ProductTrackVO productTrackVO) {
        return productTrackRepository.save(productTrackVO);
    }

    // 刪除商品追蹤
    public void deleteById(int trackNo) {
        productTrackRepository.deleteById(trackNo);
    }

    // 檢查特定商品和會員是否已在追蹤清單中
    public boolean isProductTracked(int productNo, int memberNo) {
        List<ProductTrackVO> tracks = productTrackRepository.findByProductNoAndMemberNo(productNo, memberNo);
        return !tracks.isEmpty();
    }
    // 添加商品到追蹤清單，如果它還不在清單中
    public Optional<ProductTrackVO> addToTrackList(int productNo, int memberNo) {
        if (!isProductTracked(productNo, memberNo)) {
            ProductTrackVO newTrack = new ProductTrackVO();
            newTrack.setProductNo(productNo);
            newTrack.setMemberNo(memberNo);
            // 設置其他必要的欄位
            return Optional.of(productTrackRepository.save(newTrack));
        }
        return Optional.empty();
    }

    // 移除特定商品和會員的追蹤記錄
    public void removeTrack(int productNo, int memberNo) {
        List<ProductTrackVO> tracks = productTrackRepository.findByProductNoAndMemberNo(productNo, memberNo);
        if (!tracks.isEmpty()) {
            // 假設每個商品和會員組合只有一個追蹤記錄
            productTrackRepository.delete(tracks.get(0));
        }
    }
}
