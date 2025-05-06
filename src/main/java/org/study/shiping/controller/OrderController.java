package org.study.shiping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.study.shiping.dto.OrderDto;
import org.study.shiping.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/sender/{name}")
    public List<OrderDto> getOrdersBySender(@PathVariable String name) {
        return orderService.getOrdersBySender(name);
    }

    @GetMapping("/receiver/{name}")
    public List<OrderDto> getOrdersByReceiver(@PathVariable String name) {
        return orderService.getOrdersByReceiver(name);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
        try {
            return ResponseEntity.ok(orderService.createOrderWithCargo(request));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

