package com.cha103g5.product_picture.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cha103g5.product.dao.ProductRepository;
import com.cha103g5.product.dao.ProductVO;
import com.cha103g5.product_picture.dao.ProductPictureRepository;
import com.cha103g5.product_picture.dao.ProductPictureVO;

@Service
public class ProductPictureService {

    private final ProductPictureRepository productPictureRepository;
    private final FileStorageService fileStorageService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductPictureService(ProductPictureRepository productPictureRepository,
                                 FileStorageService fileStorageService,
                                 ProductRepository productRepository) { // 修改構造函數以注入 ProductRepository
        this.productPictureRepository = productPictureRepository;
        this.fileStorageService = fileStorageService;
        this.productRepository = productRepository; // 初始化 ProductRepository
    }

    public List<ProductPictureVO> findAllProductPictures() {
        return productPictureRepository.findAll();
    }

    public Optional<ProductPictureVO> findProductPictureById(Integer productPicNo) {
        return productPictureRepository.findById(productPicNo);
    }

    public ProductPictureVO saveProductPicture(Integer productNo, MultipartFile file) {
        // 首先，存儲文件並獲取文件名
        String fileName = fileStorageService.storeFile(file);

        // 創建一個新的 ProductPictureVO 實例
        ProductPictureVO productPicture = new ProductPictureVO();
        productPicture.setProductPic(fileName);

        // 查找對應的 ProductVO 實例
        ProductVO product = productRepository.findById(productNo)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + productNo));

        // 將 ProductPictureVO 與 ProductVO 關聯
        productPicture.setProduct(product);

        // 保存 ProductPictureVO 實例到數據庫
        return productPictureRepository.save(productPicture);
    }

    public ProductPictureVO updateProductPicture(Integer productPicNo, MultipartFile newFile) {
        return productPictureRepository.findById(productPicNo).map(productPicture -> {
            try {
                String fileName = fileStorageService.storeFile(newFile);
                productPicture.setProductPic(fileName);
                return productPictureRepository.save(productPicture);
            } catch (Exception e) {
                throw new RuntimeException("Error updating file data", e);
            }
        }).orElseThrow(() -> new RuntimeException("Product Picture not found with id " + productPicNo));
    }

    public void deleteProductPicture(Integer productPicNo) {
        productPictureRepository.findById(productPicNo).ifPresent(productPicture -> {
            fileStorageService.deleteFile(productPicture.getProductPic());
            productPictureRepository.delete(productPicture);
        });
    }

    public byte[] loadFileAsResource(String fileName) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        try {
            return resource.getInputStream().readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + fileName, e);
        }
    }
}
