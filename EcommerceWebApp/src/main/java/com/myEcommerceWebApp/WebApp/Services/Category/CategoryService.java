package com.myEcommerceWebApp.WebApp.Services.Category;

import com.myEcommerceWebApp.Exception.ResourceNotFoundException;
import com.myEcommerceWebApp.WebApp.Model.Category;
import com.myEcommerceWebApp.WebApp.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceInterface {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Category Not Found.") );
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name).orElseThrow( () -> new ResourceNotFoundException("Category Not Found.") );
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public Category addCategory(Category category) {
        return  ;
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
