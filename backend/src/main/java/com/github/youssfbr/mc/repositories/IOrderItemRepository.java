package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {
}
