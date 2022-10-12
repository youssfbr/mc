package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.entities.Product;
import com.github.youssfbr.mc.services.interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    private final IProductService productService;

    public ProductResource(IProductService productService) { this.productService = productService; }

    @GetMapping
    public List<Product> listAllProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("{productId}")
    public Product listProductById(@PathVariable Long productId) {
        return productService.findProductById(productId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

}
