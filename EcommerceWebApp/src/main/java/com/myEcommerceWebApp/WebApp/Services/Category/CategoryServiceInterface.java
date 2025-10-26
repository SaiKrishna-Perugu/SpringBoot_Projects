package com.myEcommerceWebApp.WebApp.Services.Category;

import com.myEcommerceWebApp.WebApp.Model.Category;

import java.util.List;

public interface CategoryServiceInterface {

    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategory();
    Category addCategory(Category category);
    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}
