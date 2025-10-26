package com.myEcommerceWebApp.WebApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myEcommerceWebApp.Requests.AddProductRequest;
import com.myEcommerceWebApp.WebApp.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product AddProduct(AddProductRequest product);
    List<Product> findByCategory(String category);
    List<Product> findByBrand(String brand);
    List<Product> findByBrandAndCategory(String category, String brand);
    List<Product> findByName(String name);
    List<Product> findByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);
}