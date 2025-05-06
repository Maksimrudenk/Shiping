package org.study.shiping.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.study.shiping.dto.CargoDto;
import org.study.shiping.dto.CreateOrderRequest;
import org.study.shiping.dto.OrderDto;
import org.study.shiping.model.*;
import org.study.shiping.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final PortRepository portRepository;
    private final CargoRepository cargoRepository;
    private final RouteService routeService;

    public OrderService(OrderRepository orderRepository, RouteService routeService, PortRepository portRepository, ClientRepository clientRepository, CargoRepository cargoRepository) {
        this.orderRepository = orderRepository;
        this.routeService = routeService;
        this.portRepository = portRepository;
        this.clientRepository = clientRepository;
        this.cargoRepository = cargoRepository;
    }

    public List<OrderDto> getOrdersBySender(String senderName) {
        return orderRepository.findBySender_Name(senderName)
                .stream().map(this::map).collect(Collectors.toList());
    }

    public List<OrderDto> getOrdersByReceiver(String receiverName) {
        return orderRepository.findByReceiver_Name(receiverName)
                .stream().map(this::map).collect(Collectors.toList());
    }

    @Transactional
    public Long createOrderWithCargo(CreateOrderRequest request) {

        Route route = routeService.getRoute(request.departureId, request.destinationId);

        Client sender = clientRepository.findById(request.senderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid senderId"));

        Client receiver = clientRepository.findById(request.receiverId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid receiverId"));

        Port destination = portRepository.findById(request.destinationId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid destinationId"));

        Order order = new Order();
        order.setSender(sender);
        order.setReceiver(receiver);
        order.setDestination(destination);
        order.setRoute(route);
        orderRepository.save(order);

        for (CargoDto dto : request.cargo) {
            Cargo cargo = new Cargo();
            cargo.setType(dto.type);
            cargo.setWeight(dto.weight);
            cargo.setState("NEW");
            cargo.setOrder(order);
            cargoRepository.save(cargo);
        }

        return order.getId();
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

