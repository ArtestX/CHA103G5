package com.cha103g5.product.service;

import com.cha103g5.product.dao.ProductRepository;
import com.cha103g5.product.dao.ProductVO;
import com.cha103g5.product_picture.dao.ProductPictureVO;
import com.cha103g5.product_picture.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;
    @Autowired
    public ProductService(ProductRepository productRepository, FileStorageService fileStorageService) {
        this.productRepository = productRepository;
        this.fileStorageService = fileStorageService; // 初始化 FileStorageService
    }

    public ProductVO addProduct(ProductVO product) {
        // 在這裡，您可以添加邏輯來處理圖片上傳並設置 productImagePath
        return productRepository.save(product);
    }

    public ProductVO updateProduct(ProductVO product) {
        // 在這裡，您可以添加邏輯來處理圖片更新並設置 productImagePath
        return productRepository.save(product);
    }

    public void deleteProduct(Integer productNo) {
        // 在這裡，您可以添加邏輯來刪除與產品相關的圖片文件
        productRepository.deleteById(productNo);
    }

    public ProductVO getOneProduct(Integer productNo) {
        return productRepository.findById(productNo).orElse(null);
    }

    public List<ProductVO> getAll() {
        return productRepository.findAll();
    }

    public List<ProductVO> getAllAvailableProducts() {
        return productRepository.findByProductStat(1); // 假設 1 表示上架
    }

    public boolean updateProductStatus(Integer productNo, Integer status) {
        ProductVO product = productRepository.findById(productNo)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 檢查 productStat 是否為 null，並進行比較
        if ((product.getProductStat() == null && status == null) ||
                (product.getProductStat() != null && product.getProductStat().equals(status))) {
            return false; // 狀態沒有變化
        }
        product.setProductStat(status);
        productRepository.save(product);
        return true; // 狀態更新成功
    }

    public List<ProductVO> searchProductsByCategory(String keyword, Integer productCatNo) {
        return productRepository.findByProductNameContainingAndProductCatNo(keyword, productCatNo);
    }

    public List<ProductVO> getProductsByCategory(Integer productCatNo) {
        return productRepository.findByProductCatNo(productCatNo);
    }

    public List<ProductVO> searchProducts(String keyword) {
        return productRepository.findByProductNameContaining(keyword);
    }

    // 更新方法用於處理圖片上傳
    public ProductVO addProductImages(Integer productNo, List<MultipartFile> files) {
        ProductVO product = productRepository.findById(productNo).orElseThrow(() -> new RuntimeException("Product not found"));
        List<ProductPictureVO> productPictures = files.stream().map(file -> {
            String imagePath = fileStorageService.storeFile(file); // 上傳檔案並獲取路徑
            ProductPictureVO productPicture = new ProductPictureVO();
            productPicture.setProductPic(imagePath);
            productPicture.setProduct(product); // 設置關聯
            return productPicture;
        }).collect(Collectors.toList());

        product.getProductPictures().addAll(productPictures); // 添加到產品圖片集合中
        return productRepository.save(product); // 儲存產品和圖片資訊
    }

    // 修改刪除產品的方法
    public void deleteProductAndImages(Integer productNo) {
        ProductVO product = productRepository.findById(productNo).orElse(null);
        if (product != null) {
            List<ProductPictureVO> productPictures = product.getProductPictures();
            if (productPictures != null) {
                productPictures.forEach(picture -> fileStorageService.deleteFile(picture.getProductPic())); // 刪除檔案
                productPictures.clear(); // 清空關聯
            }
            productRepository.delete(product); // 刪除產品和關聯的圖片
        }
    }

    public ProductVO updateProductImages(Integer productNo, List<MultipartFile> files) {
        ProductVO product = productRepository.findById(productNo).orElseThrow(() -> new RuntimeException("Product not found"));

        // 可以選擇刪除舊的圖片
        product.getProductPictures().forEach(picture -> fileStorageService.deleteFile(picture.getProductPic()));
        product.getProductPictures().clear();

        // 添加新的圖片
        List<ProductPictureVO> productPictures = files.stream().map(file -> {
            String imagePath = fileStorageService.storeFile(file); // 上傳檔案並獲取路徑
            ProductPictureVO productPicture = new ProductPictureVO();
            productPicture.setProductPic(imagePath);
            productPicture.setProduct(product); // 設置關聯
            return productPicture;
        }).collect(Collectors.toList());

        product.getProductPictures().addAll(productPictures); // 添加到產品圖片集合中
        return productRepository.save(product); // 儲存產品和圖片資訊
    }
    // 新增方法以根據商品編號獲取商品信息
    public ProductVO getProductById(Integer productNo) {
        return productRepository.findByProductNo(productNo).orElse(null);
    }


    public List<ProductVO> searchByKeyword(String keyword) {
        // 使用商品名稱中包含關鍵字來搜尋商品
        return productRepository.findByProductNameContaining(keyword);
    }

    public List<ProductVO> searchByKeywordAndCategory(String keyword, Integer productCatNo) {
        // 使用商品名稱中包含關鍵字並且特定分類編號來搜尋商品
        return productRepository.findByProductNameContainingAndProductCatNo(keyword, productCatNo);
    }


}
