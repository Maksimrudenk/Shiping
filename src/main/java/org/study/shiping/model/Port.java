package org.study.shiping.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Port")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;

    private String country;

    private Integer capacity;

    private String contactInfo;
}
