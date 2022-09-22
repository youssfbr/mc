package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.entities.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @GetMapping
    public List<Category> listCategories() {

        List<Category> list = new ArrayList<>();
        list.add(new Category(1L, "Informática"));
        list.add(new Category(2L, "Escritório"));

        return list;
    }

}
