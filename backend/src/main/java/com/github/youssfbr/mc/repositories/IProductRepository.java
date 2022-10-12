package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
