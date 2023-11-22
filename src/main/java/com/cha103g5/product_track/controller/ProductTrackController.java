package com.cha103g5.product_track.controller;

import com.cha103g5.product_track.dao.ProductTrackVO;
import com.cha103g5.product_track.service.ProductTrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/productTrack")
public class ProductTrackController {

    private static final Logger logger = LoggerFactory.getLogger(ProductTrackController.class);

    @Autowired
    private ProductTrackService productTrackService;

    // 根據追蹤編號獲取單個商品追蹤
    @GetMapping("/{trackNo}")
    public ResponseEntity<ProductTrackVO> getProductTrack(@PathVariable int trackNo) {
        Optional<ProductTrackVO> productTrack = productTrackService.findById(trackNo);
        return productTrack.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 新增商品追蹤
    @PostMapping("/add")
    public ResponseEntity<ProductTrackVO> addProductTrack(@RequestBody ProductTrackVO productTrackVO) {
        ProductTrackVO newProductTrack = productTrackService.save(productTrackVO);
        return ResponseEntity.ok(newProductTrack);
    }

    // 更新商品追蹤
    @PutMapping("/update")
    public ResponseEntity<ProductTrackVO> updateProductTrack(@RequestBody ProductTrackVO productTrackVO) {
        ProductTrackVO updatedProductTrack = productTrackService.update(productTrackVO);
        return ResponseEntity.ok(updatedProductTrack);
    }

    // 刪除商品追蹤
    @DeleteMapping("/delete/{trackNo}")
    public ResponseEntity<Void> deleteProductTrack(@PathVariable int trackNo) {
        productTrackService.deleteById(trackNo);
        return ResponseEntity.ok().build();
    }

    // 添加商品到追蹤清單，如果它還不在清單中
    @PostMapping("/addToTrackList")
    public ResponseEntity<String> addToTrackList(@RequestParam int productNo, @RequestParam int memberNo) {
        // 檢查是否已追蹤，如果已追蹤則取消追蹤
        if (productTrackService.isProductTracked(productNo, memberNo)) {
            productTrackService.removeTrack(productNo, memberNo);
            logger.info("Product with ID " + productNo + " removed from track list by member " + memberNo);
            return ResponseEntity.ok("Product removed from track list");
        } else {
            // 如果未追蹤則添加追蹤
            productTrackService.addToTrackList(productNo, memberNo);
            logger.info("Product with ID " + productNo + " added to track list by member " + memberNo);
            return ResponseEntity.ok("Product added to track list");
        }
    }

    // 添加或移除商品追蹤
    @PostMapping("/toggleTrack")
    public String toggleProductTrack(@RequestParam int productNo, @RequestParam int memberNo, RedirectAttributes redirectAttributes) {
        // 檢查是否已追蹤，如果已追蹤則取消追蹤，否則添加追蹤
        if (productTrackService.isProductTracked(productNo, memberNo)) {
            productTrackService.removeTrack(productNo, memberNo);
            redirectAttributes.addFlashAttribute("flashMessage", "Product removed from track list");
        } else {
            productTrackService.addToTrackList(productNo, memberNo);
            redirectAttributes.addFlashAttribute("flashMessage", "Product added to track list");
        }
        return "redirect:/mall";
    }

    @PostMapping("/toggleTrackAjax")
    public ResponseEntity<?> toggleTrackAjax(@RequestParam("productNo") int productNo,
                                             @RequestParam("memberNo") int memberNo) {
        logger.info("toggleTrackAjax called with productNo: " + productNo + ", memberNo: " + memberNo);
        Map<String, Object> response = new HashMap<>();

        boolean isTracked;
        if (productTrackService.isProductTracked(productNo, memberNo)) {
            productTrackService.removeTrack(productNo, memberNo);
            isTracked = false;
        } else {
            productTrackService.addToTrackList(productNo, memberNo);
            isTracked = true;
        }
        response.put("tracked", isTracked);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/favorites/{memberNo}")
    public ResponseEntity<List<ProductTrackVO>> getFavoritesByMember(@PathVariable int memberNo) {
        List<ProductTrackVO> favorites = productTrackService.findTracksByMemberNo(memberNo);
        return ResponseEntity.ok(favorites);
    }

    // 獲取所有商品追蹤清單，包含商品名稱
    @GetMapping("/all")
    public ResponseEntity<List<ProductTrackVO>> getAllProductTracks() {
        List<ProductTrackVO> productTracks = productTrackService.findAllWithProductName();
        return ResponseEntity.ok(productTracks);
    }

}

