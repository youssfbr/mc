package com.github.youssfbr.mc.repositories;

import com.github.youssfbr.mc.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
