package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.dto.request.CategoryAllDTO;
import com.github.youssfbr.mc.dto.request.CategoryDTO;
import com.github.youssfbr.mc.dto.response.MessageResponseDTO;
import com.github.youssfbr.mc.services.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryResource {

    private final ICategoryService categoryService;

    @GetMapping("/page")
    public Page<CategoryAllDTO> listAllPagesCategories(Pageable pageable) { return categoryService.listAllPagesCategories(pageable); }

    @GetMapping
    public List<CategoryAllDTO> listAllCategories() { return categoryService.listAllCategories(); }

    @GetMapping("{categoryId}")
    public CategoryDTO findCategoryById(@PathVariable Long categoryId) { return categoryService.findCategoryById(categoryId); }

    @PostMapping
    public ResponseEntity<MessageResponseDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDto) {

        MessageResponseDTO category = categoryService.createCategory(categoryDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).body(category);
    }

    @PutMapping("{categoryId}")
    public MessageResponseDTO updateCategory(@PathVariable Long categoryId, @RequestBody @Valid CategoryDTO categoryDto) {
        return categoryService.updateCategory(categoryId, categoryDto);
    }

    @DeleteMapping("{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

}
