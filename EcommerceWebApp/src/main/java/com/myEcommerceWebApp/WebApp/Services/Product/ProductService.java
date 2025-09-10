package com.myEcommerceWebApp.WebApp.Services.Product;

import java.util.List;

import com.myEcommerceWebApp.WebApp.Model.Product;

public interface ProductService {

    Product addProduct(Product product);
    Product getProductById(Long id);
    void updateProduct(Product product, Long productId);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByBrandAndCategory(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);

}
