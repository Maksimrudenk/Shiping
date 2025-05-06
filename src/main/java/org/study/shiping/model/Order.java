package org.study.shiping.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"order\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "\"sender\"", nullable = false)
    private Client sender;

    @ManyToOne
    @JoinColumn(name = "\"reciever\"", nullable = false)
    private Client receiver;

    @ManyToOne
    @JoinColumn(name = "\"destination\"", nullable = false)
    private Port destination;

    @ManyToOne
    @JoinColumn(name = "\"rout\"", nullable = false)
    private Route route;

    @OneToMany(mappedBy = "order")
    private List<Cargo> cargos = new ArrayList<>();
}

