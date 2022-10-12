package com.github.youssfbr.mc.services;

import com.github.youssfbr.mc.entities.Product;
import com.github.youssfbr.mc.repositories.IProductRepository;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.mc.services.interfaces.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) { this.productRepository = productRepository; }

    @Override
    @Transactional(readOnly = true)
    public List<Product> listAllProducts() { return productRepository.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(Long productId) {
        return productRepository
                .findById(productId)
                .orElseThrow (() -> new ResourceNotFoundException("Produto não encontrado com id " + productId));
        }

    @Override
    @Transactional
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

}
