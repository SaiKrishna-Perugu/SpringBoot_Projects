package com.myEcommerceWebApp.WebApp.Services.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myEcommerceWebApp.Exception.ProductNotFoundException;
import com.myEcommerceWebApp.WebApp.Model.Product;
import com.myEcommerceWebApp.WebApp.Repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found."));
    }

    @Override
    public void updateProduct(Product product, Long productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete , 
                            () -> { throw new ProductNotFoundException("Product Not Found."); });
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByBrandAndCategory(String category, String brand) {
        return productRepository.findByBrandAndCategory(brand, category);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countProductsByBrandAndName(brand, name);
    }

}
