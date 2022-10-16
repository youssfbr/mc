package com.github.youssfbr.mc.services.interfaces;

import com.github.youssfbr.mc.entities.Order;

import java.util.List;

public interface IOrderService {

    List<Order> listAllOrders();
    Order findOrderById(Long orderId);
    Order insertOrder(Order order);

}
