package org.study.shiping.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Client sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Client receiver;

    @ManyToOne
    @JoinColumn(name = "destination_port_id", nullable = false)
    private Port destinationPoint;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @OneToMany(mappedBy = "order")
    private List<Cargo> cargos = new ArrayList<>();
}

