package com.github.youssfbr.mc.services;

import com.github.youssfbr.mc.entities.Category;
import com.github.youssfbr.mc.repositories.ICategoryRepository;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.mc.services.interfaces.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findCategoryById(Long categoryId) {
        return categoryRepository
                .findById(categoryId)
                .orElseThrow (() -> new ResourceNotFoundException("Categoria não encontrada com id " + categoryId));
    }
}
