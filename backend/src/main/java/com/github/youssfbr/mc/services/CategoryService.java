package com.github.youssfbr.mc.services;

import com.github.youssfbr.mc.dto.request.CategoryAllDTO;
import com.github.youssfbr.mc.dto.request.CategoryDTO;
import com.github.youssfbr.mc.dto.response.MessageResponseDTO;
import com.github.youssfbr.mc.entities.Category;
import com.github.youssfbr.mc.mappers.CategoryMapper;
import com.github.youssfbr.mc.repositories.ICategoryRepository;
import com.github.youssfbr.mc.services.exceptions.DataIntegrityException;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.mc.services.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;
    private static final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Override
    @Transactional(readOnly = true)
    public Page<CategoryAllDTO> listAllPagesCategories(Pageable pageable) {
        return categoryRepository
                .findAll(pageable)
                .map(categoryMapper::allToDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryAllDTO> listAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::allToDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO findCategoryById(Long categoryId) {
        
        Category category = verifyIfExists(categoryId);

        return categoryMapper.toDto(category);
    }

    @Override
    @Transactional
    public MessageResponseDTO createCategory(CategoryDTO categoryDto) {

        Category categoryToSave = categoryMapper.toModel(categoryDto);

        Category savedCategory = categoryRepository.save(categoryToSave);

        return createMessageResponse(savedCategory.getId(), "Categoria criada com ID ");
    }

    @Override
    @Transactional
    public MessageResponseDTO updateCategory(Long categoryId, CategoryDTO categoryDto) {

        verifyIfExists(categoryId);

        Category categoryToUpdate = categoryMapper.toModel(categoryDto);

        Category updatedCategory = categoryRepository.save(categoryToUpdate);

        return createMessageResponse(updatedCategory.getId(), "Categoria atualizada com ID ");
    }

    @Override
    public void deleteCategory(Long categoryId) {

        verifyIfExists(categoryId);

        try {
            categoryRepository.deleteById(categoryId);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
        }
    }

    private Category verifyIfExists(Long categoryId) {
        return categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com id " + categoryId + " não encontrada."));
    }

    private MessageResponseDTO createMessageResponse(Long categoryId, String message) {
        return MessageResponseDTO
                .builder()
                .id(categoryId)
                .message(message + categoryId)
                .build();
    }

}
