package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.study.shiping.model.Ship;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Long> {
    @Query("""
        SELECT s FROM Ship s
        LEFT JOIN Route r ON s.id = r.ship.id
        WHERE s.state = 'Active' AND r.id IS NULL
    """)
    List<Ship> findActiveShipsWithoutRoute();
}
