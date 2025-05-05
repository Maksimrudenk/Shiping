package org.study.shiping.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cargo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    private String type;

    private Double weight;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}

