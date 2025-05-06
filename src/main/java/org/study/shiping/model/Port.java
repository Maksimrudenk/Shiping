package org.study.shiping.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Port")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonProperty
    private Long id;

    @Column(nullable = false)
//    @JsonProperty
    private String name;

//    @JsonProperty
    private String city;

    private String country;

    private Integer capacity;

    private String contact;

    @Override
    public String toString() {
        return "Port{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", capacity=" + capacity +
                ", contact='" + contact + '\'' +
                '}';
    }
}
