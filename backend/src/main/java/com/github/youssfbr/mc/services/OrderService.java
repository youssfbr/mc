package com.github.youssfbr.mc.services;

import com.github.youssfbr.mc.entities.Order;
import com.github.youssfbr.mc.repositories.IOrderRepository;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.mc.services.interfaces.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) { this.orderRepository = orderRepository; }

    @Override
    @Transactional(readOnly = true)
    public List<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order findOrderById(Long orderId) {
        return orderRepository
                .findById(orderId)
                .orElseThrow (() -> new ResourceNotFoundException("Pedido com id " + orderId + " não encontrado."));
    }

    @Override
    @Transactional
    public Order insertOrder(Order order) {
        return orderRepository.save(order);
    }

}
