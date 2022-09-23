package com.github.youssfbr.mc.services.interfaces;

import com.github.youssfbr.mc.entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> listAllCategories();
    Category findCategoryById(Long categoryId);
    Category insertCategory(Category category);

}
