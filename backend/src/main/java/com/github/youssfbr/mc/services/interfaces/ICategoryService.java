package com.github.youssfbr.mc.services.interfaces;

import com.github.youssfbr.mc.dto.request.CategoryAllDTO;
import com.github.youssfbr.mc.dto.request.CategoryDTO;
import com.github.youssfbr.mc.dto.response.MessageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    Page<CategoryAllDTO> listAllPagesCategories(Pageable pageable);
    List<CategoryAllDTO> listAllCategories();
    CategoryDTO findCategoryById(Long categoryId);
    MessageResponseDTO createCategory(CategoryDTO categoryDto);
    MessageResponseDTO updateCategory(Long categoryId, CategoryDTO categoryDto);
    void deleteCategory(Long categoryId);

}
