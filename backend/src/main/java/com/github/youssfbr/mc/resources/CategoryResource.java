package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.entities.Category;
import com.github.youssfbr.mc.services.interfaces.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    private final ICategoryService categoryService;

    public CategoryResource(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> listAllCategories() {
        return categoryService.listAllCategories();
    }

    @GetMapping("{categoryId}")
    public Category listCategoryById(@PathVariable Long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category insertCategory(@RequestBody Category category) {
        return categoryService.insertCategory(category);
    }

}
