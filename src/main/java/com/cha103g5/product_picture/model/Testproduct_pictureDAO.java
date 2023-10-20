package com.cha103g5.product_picture.model;

import java.util.List;

public class Testproduct_pictureDAO {

    public static void main(String[] args) {
        Product_pictureDAO product_pictureDAO = new Product_pictureDAOImpl();

        // 新增商品圖片
//        Product_picture productPicture1 = new Product_picture();
//        productPicture1.setProductNo(1); // 設定商品編號
//        productPicture1.setProductPic("example1.jpg"); // 設定商品圖片名稱
//        int insertResult1 = product_pictureDAO.insert(productPicture1);
//        if (insertResult1 > 0) {
//            System.out.println("商品圖片插入成功，圖片編號：" + insertResult1);
//        } else {
//            System.out.println("商品圖片插入失敗");
//        }
//
//        // 新增另一張商品圖片
//        Product_picture productPicture2 = new Product_picture();
//        productPicture2.setProductNo(1); // 設定商品編號
//        productPicture2.setProductPic("example2.jpg"); // 設定商品圖片名稱
//        int insertResult2 = product_pictureDAO.insert(productPicture2);
//        if (insertResult2 > 0) {
//            System.out.println("商品圖片插入成功，圖片編號：" + insertResult2);
//        } else {
//            System.out.println("商品圖片插入失敗");
//        }
//
//        // 根據編號獲取商品圖片
//        int productPicNoToRetrieve = insertResult1; // 使用上面插入的圖片編號
//        Product_picture retrievedProductPicture = product_pictureDAO.getById(productPicNoToRetrieve);
//        if (retrievedProductPicture != null) {
//            System.out.println("根據編號獲取的商品圖片信息：" + retrievedProductPicture);
//        } else {
//            System.out.println("未找到商品圖片");
//        }
//
//        // 獲取所有商品圖片
//        List<Product_picture> allProductPictures = product_pictureDAO.getAll();
//        if (allProductPictures != null && !allProductPictures.isEmpty()) {
//            System.out.println("所有商品圖片列表：");
//            for (Product_picture productPicture : allProductPictures) {
//                System.out.println(productPicture);
//            }
//        } else {
//            System.out.println("沒有商品圖片存在");
//        }
//
//        // 修改商品圖片
//        if (retrievedProductPicture != null) {
//            retrievedProductPicture.setProductPic("new_example.jpg"); // 更新圖片名稱
//            int updateResult = product_pictureDAO.update(retrievedProductPicture);
//            if (updateResult > 0) {
//                System.out.println("商品圖片更新成功");
//            } else {
//                System.out.println("商品圖片更新失敗");
//            }
//        }
//
//        // 刪除商品圖片
//        int productPicNoToDelete = insertResult2; // 使用第二張圖片的編號
//        int deleteResult = product_pictureDAO.delete(productPicNoToDelete);
//        if (deleteResult > 0) {
//            System.out.println("商品圖片刪除成功");
//        } else {
//            System.out.println("商品圖片刪除失敗");
//        }
        
     // 查詢多筆
        List< Product_picture>  product_pictures = product_pictureDAO.getAll();
        for ( Product_picture product_picture : product_pictures) {
            System.out.println(product_picture);
        }
    }
}
