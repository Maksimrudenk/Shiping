package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.shiping.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findBySender_Name(String name);
    List<Order> findByReceiver_Name(String name);
}
