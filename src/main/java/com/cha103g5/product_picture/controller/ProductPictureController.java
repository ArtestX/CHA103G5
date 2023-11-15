package com.cha103g5.product_picture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cha103g5.product.service.ProductService;
import com.cha103g5.product_picture.dao.ProductPictureVO;
import com.cha103g5.product_picture.service.ProductPictureService;

@Controller
@RequestMapping("/product-pictures")
public class ProductPictureController {

    private final ProductPictureService productPictureService;
    private final ProductService productService; // 假設您有一個 ProductService

    @Autowired
    public ProductPictureController(ProductPictureService productPictureService, ProductService productService) {
        this.productPictureService = productPictureService;
        this.productService = productService; // 自動注入 ProductService
    }
    @GetMapping
    public List<ProductPictureVO> getAllProductPictures() {
        return productPictureService.findAllProductPictures();
    }

    @GetMapping("/{productPicNo}")
    public ResponseEntity<ProductPictureVO> getProductPictureById(@PathVariable Integer productPicNo) {
        return productPictureService.findProductPictureById(productPicNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/uploadForm/{productNo}")
    public String uploadProductPicture(@PathVariable Integer productNo,
                                       @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        // 添加日誌
        System.out.println("Uploading file for product number: " + productNo);

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "檔案為空");
            return "redirect:/product-pictures/uploadForm/" + productNo;
        }

        try {
            // 假設您的 service 層需要產品編號和文件來保存圖片
            ProductPictureVO productPicture = productPictureService.saveProductPicture(productNo, file);
            redirectAttributes.addFlashAttribute("message", "檔案上傳成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "無法上傳檔案: " + file.getOriginalFilename());
        }

        return "redirect:/product-pictures/uploadForm/" + productNo;
    }




    @DeleteMapping("/{productPicNo}")
    public ResponseEntity<Void> deleteProductPicture(@PathVariable Integer productPicNo) {
        productPictureService.deleteProductPicture(productPicNo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/uploadForm/{productNo}")
    public String showUploadForm(@PathVariable Integer productNo, Model model) {
        model.addAttribute("productNo", productNo);
        return "uploadForm"; // 確保這個視圖名稱與您的模板文件名匹配
    }
}
