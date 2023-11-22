package com.cha103g5.product_track.service;

import com.cha103g5.product.dao.ProductVO;
import com.cha103g5.product.service.ProductService;
import com.cha103g5.product_track.dao.ProductTrackVO;
import com.cha103g5.product_track.dao.ProductTrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTrackService {

    private static final Logger logger = LoggerFactory.getLogger(ProductTrackService.class);


    @Autowired
    private ProductTrackRepository productTrackRepository;

    @Autowired
    private ProductService productService;

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
    @Transactional
    public Optional<ProductTrackVO> addToTrackList(int productNo, int memberNo) {
        if (!isProductTracked(productNo, memberNo)) {
            ProductTrackVO newTrack = new ProductTrackVO();
            newTrack.setProductNo(productNo);
            newTrack.setMemberNo(memberNo);
            // 設置其他必要的欄位
            ProductTrackVO savedTrack = productTrackRepository.save(newTrack);
            logger.info("Track added: " + savedTrack.getTrackNo());
            return Optional.of(savedTrack);
        } else {
            logger.info("Track already exists for productNo: " + productNo + ", memberNo: " + memberNo);
            return Optional.ofNullable(productTrackRepository.findByProductNoAndMemberNo(productNo, memberNo).get(0));
        }
    }

    @Transactional
    public void removeTrack(int productNo, int memberNo) {
        List<ProductTrackVO> tracks = productTrackRepository.findByProductNoAndMemberNo(productNo, memberNo);
        if (!tracks.isEmpty()) {
            ProductTrackVO track = tracks.get(0);
            if (productTrackRepository.existsById(track.getTrackNo())) {
                productTrackRepository.delete(track);
                logger.info("Track removed: " + track.getTrackNo());
            } else {
                logger.error("Attempted to delete a non-existent track record with trackNo: " + track.getTrackNo());
            }
        } else {
            logger.info("No track found to remove for productNo: " + productNo + ", memberNo: " + memberNo);
        }
    }


    public List<ProductTrackVO> findAllWithProductName() {
        List<ProductTrackVO> tracks = productTrackRepository.findAll();
        tracks.forEach(track -> {
            ProductVO product = productService.getProductById(track.getProductNo());
            if (product != null) {
                logger.info("Product found with name: " + product.getProductName()); // 日誌輸出商品名稱
                track.setProductName(product.getProductName());
            } else {
                logger.error("Product not found for productNo: " + track.getProductNo()); // 商品未找到的日誌輸出
            }
        });
        return tracks;
    }

    public List<ProductTrackVO> findTracksByMemberNo(int memberNo) {
        List<ProductTrackVO> tracks = productTrackRepository.findByMemberNo(memberNo);
        tracks.forEach(track -> {
            ProductVO product = productService.getProductById(track.getProductNo());
            if (product != null) {
                track.setProductName(product.getProductName());
            } else {
                track.setProductName("Product name not available");
            }
        });
        return tracks;
    }

}
