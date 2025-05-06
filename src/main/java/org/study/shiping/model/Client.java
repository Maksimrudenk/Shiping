package org.study.shiping.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String contact_info;

    @OneToMany(mappedBy = "sender")
    private List<Order> sentOrders = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<Order> receivedOrders = new ArrayList<>();
}
