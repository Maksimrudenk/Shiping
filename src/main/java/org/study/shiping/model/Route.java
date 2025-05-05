package org.study.shiping.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Route")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double distance;

    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "departure_port_id", nullable = false)
    private Port departurePoint;

    @ManyToOne
    @JoinColumn(name = "destination_port_id", nullable = false)
    private Port destinationPoint;

    @OneToMany(mappedBy = "route")
    private List<Order> orders = new ArrayList<>();
}

