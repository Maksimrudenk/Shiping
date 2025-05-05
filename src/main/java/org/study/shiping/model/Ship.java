package org.study.shiping.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ship")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double capacity;

    private String type;

    private String state;

    @OneToMany(mappedBy = "ship")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "ship")
    private List<Route> routes = new ArrayList<>();
}
