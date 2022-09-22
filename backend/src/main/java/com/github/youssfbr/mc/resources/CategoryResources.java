package com.github.youssfbr.mc.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryResources {

    @GetMapping
    public String listCategories() {
        return "OK";
    }

}
