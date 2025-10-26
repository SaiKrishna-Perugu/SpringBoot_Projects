package com.myEcommerceWebApp.WebApp.Services.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myEcommerceWebApp.Exception.ProductNotFoundException;
import com.myEcommerceWebApp.Requests.AddProductRequest;
import com.myEcommerceWebApp.Requests.ProductUpdateRequest;
import com.myEcommerceWebApp.WebApp.Model.Category;
import com.myEcommerceWebApp.WebApp.Model.Product;
import com.myEcommerceWebApp.WebApp.Repository.CategoryRepository;
import com.myEcommerceWebApp.WebApp.Repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInterface {

    private final ProductRepository productRepository;  
    private final CategoryRepository categoryRepository;

    @Override
    public Product addProduct(AddProductRequest request) {

        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(request.getCategory().getName());
                    categoryRepository.save(newCategory);
                    return newCategory;
                });

        return productRepository.save(createProduct(request, category));
    }
 
    private Product createProduct(AddProductRequest request, Category category) {
        return new Product( request.getName(), 
                            request.getBrand(), 
                            request.getPrice(), 
                            request.getInventory(),
                            request.getDescription(), 
                            category
                            );
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found."));
    }

    @Override
    public Product updateProduct(ProductUpdateRequest request, Long productId) {
        return productRepository.findById(productId)
                .map(existingProduct -> updateExistingProduct(existingProduct,request))
                .map(productRepository :: save)
                .orElseThrow(()-> new ProductNotFoundException("Product not found!"));

    }

    private Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request) {
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setDescription(request.getDescription());

        Category category = categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category);
        return  existingProduct;

    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete, () -> {
            throw new ProductNotFoundException("Product Not Found.");
        });
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
