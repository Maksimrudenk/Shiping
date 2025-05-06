package org.study.shiping.service;

import org.springframework.stereotype.Service;
import org.study.shiping.dto.OrderDto;
import org.study.shiping.model.Order;
import org.study.shiping.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getOrdersBySender(String senderName) {
        return orderRepository.findBySender_Name(senderName)
                .stream().map(this::map).collect(Collectors.toList());
    }

    public List<OrderDto> getOrdersByReceiver(String receiverName) {
        return orderRepository.findByReceiver_Name(receiverName)
                .stream().map(this::map).collect(Collectors.toList());
    }

    private OrderDto map(Order o) {
        OrderDto dto = new OrderDto();
        dto.id = o.getId();
        dto.senderName = o.getSender().getName();
        dto.receiverName = o.getReceiver().getName();
        dto.destinationPortId = o.getDestination().getId();
        dto.destinationPortName = o.getDestination().getName();
        dto.routeId = o.getRoute().getId();
        dto.departurePortId = o.getRoute().getDeparture().getId();
        dto.departurePortName = o.getRoute().getDeparture().getName();
        return dto;
    }
}

