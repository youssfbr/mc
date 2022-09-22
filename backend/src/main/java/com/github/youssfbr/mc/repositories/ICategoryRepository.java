package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
