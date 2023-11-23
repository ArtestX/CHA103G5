package com.cha103g5.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cha103g5.product.dao.ProductVO;
import com.cha103g5.product.service.ProductService;
import com.cha103g5.product_category.dao.Product_categoryVO;
import com.cha103g5.product_category.service.ProductCategoryService;

@Controller
public class MyController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/mall")
    public String mallPage(Model model) {
        List<ProductVO> products = productService.getAllAvailableProducts();
        List<Product_categoryVO> categories = productCategoryService.getAllProductCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "mall";
    }

    @GetMapping("/allProduct")
    public String allProduct(Model model) {
        List<ProductVO> products = productService.getAll();
        List<Product_categoryVO> categories = productCategoryService.getAllProductCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        // 確保 statusUnchanged 不被設置或設置為 false
        model.addAttribute("statusUnchanged", false);
        return "allProduct";
    }

    @DeleteMapping("/deleteProduct/{productNo}")
    public String deleteProduct(@PathVariable Integer productNo) {
        productService.deleteProductAndImages(productNo);
        return "redirect:/allProduct";
    }

    @GetMapping("/editProduct/{productNo}")
    public String showEditForm(@PathVariable Integer productNo, Model model) {
        ProductVO product = productService.getOneProduct(productNo);
        List<Product_categoryVO> categories = productCategoryService.getAllProductCategories();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "/editProduct";
    }

    @PostMapping("/updateProduct/{productNo}")
    public String updateProduct(@PathVariable Integer productNo, @ModelAttribute ProductVO product, @RequestParam("images") List<MultipartFile> images) {
        // 先獲取原有的產品資訊，包括圖片
        ProductVO existingProduct = productService.getOneProduct(productNo);
        if (existingProduct != null) {
            product.setProductPictures(existingProduct.getProductPictures());
        }
        // 更新產品資訊
        productService.updateProduct(product);
        // 只有在有圖片上傳時才更新圖片
        if (images != null && !images.isEmpty() && images.stream().anyMatch(image -> !image.isEmpty())) {
            productService.updateProductImages(product.getProductNo(), images);
        }
        return "redirect:/allProduct";
    }

    @GetMapping("/addProduct")
    public String showAddForm(Model model) {
        List<Product_categoryVO> categories = productCategoryService.getAllProductCategories();
        model.addAttribute("product", new ProductVO());
        model.addAttribute("categories", categories);
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute ProductVO product, @RequestParam("images") List<MultipartFile> images, RedirectAttributes redirectAttributes) {
        try {
            productService.addProduct(product); // 首先添加產品
            if (images != null && !images.isEmpty()) {
                productService.addProductImages(product.getProductNo(), images); // 然後處理圖片上傳
            }
            return "redirect:/allProduct";
        } catch (Exception e) {
            String errorMessage = "處理時發生錯誤：" + e.getMessage();
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/addProduct";
        }
    }

    @PostMapping("/updateProductStatus")
    public String updateProductStatus(@RequestParam("productNo") Integer productNo, @RequestParam("status") Integer status, RedirectAttributes redirectAttributes) {
        boolean isUpdated = productService.updateProductStatus(productNo, status);
        redirectAttributes.addFlashAttribute("statusUpdated", isUpdated);
        return "redirect:/allProduct";
    }



    @GetMapping("/search")
    public String search(@RequestParam String keyword, @RequestParam(required = false) Integer categoryId, Model model) {
        List<ProductVO> products;
        if (categoryId != null) {
            products = productService.searchProductsByCategory(keyword, categoryId);
        } else {
            products = productService.searchProducts(keyword);
        }
        model.addAttribute("products", products);
        return "searchResults";
    }

    @GetMapping("/category/{categoryId}")
    public String browseByCategory(@PathVariable Integer categoryId, Model model) {
        List<ProductVO> products = productService.getProductsByCategory(categoryId);
        model.addAttribute("products", products);
        return "categoryProducts";
    }

    @GetMapping("/product/details/{productNo}")
    public String getProductDetails(@PathVariable Integer productNo, Model model) {
        ProductVO product = productService.getOneProduct(productNo);
        if (product != null) {
            model.addAttribute("product", product);
            return "productDetails";
        } else {
            return "error";
        }
    }

    @GetMapping("/searchProducts")
    public String searchProducts(@RequestParam("keyword") String keyword, Model model) {
        List<ProductVO> searchResults = productService.searchByKeyword(keyword);
        if (searchResults.isEmpty()) {
            model.addAttribute("noProductsFound", true); // 沒有找到產品時設置標誌
        } else {
            model.addAttribute("products", searchResults);
        }
        return "mall";  // 返回商品列表頁面
    }


}
