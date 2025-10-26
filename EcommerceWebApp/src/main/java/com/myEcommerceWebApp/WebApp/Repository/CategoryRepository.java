package com.myEcommerceWebApp.WebApp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.myEcommerceWebApp.WebApp.Model.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    List<Category> getAllCategories();
}