package com.github.youssfbr.mc.services.interfaces;

import com.github.youssfbr.mc.entities.Product;

import java.util.List;

public interface IProductService {

    List<Product> listAllProducts();
    Product findProductById(Long productId);
    Product insertProduct(Product product);

}
