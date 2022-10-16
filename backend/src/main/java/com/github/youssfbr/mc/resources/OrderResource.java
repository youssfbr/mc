package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.entities.Order;
import com.github.youssfbr.mc.services.interfaces.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final IOrderService orderService;

    public OrderResource(IOrderService orderService) { this.orderService = orderService; }

    @GetMapping
    public List<Order> listAllOrders() {
        return orderService.listAllOrders();
    }

    @GetMapping("{orderId}")
    public Order listCategoryById(@PathVariable Long orderId) { return orderService.findOrderById(orderId); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order insertCategory(@RequestBody Order order) { return orderService.insertOrder(order); }

}
