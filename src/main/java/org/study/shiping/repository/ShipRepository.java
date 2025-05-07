package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.study.shiping.model.Ship;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query("""
    SELECT COUNT(s) FROM 
    Ship s LEFT JOIN s.routes r 
    WHERE s.state = 'Active' AND r IS NULL
    """)
    long countActiveShipsNotInRoutes();

//    @Query("""
//    SELECT s FROM Ship s
//    WHERE s.state = 'Active' AND s.id NOT IN (
//        SELECT r.ship.id FROM Route r
//        WHERE r.ship IS NOT NULL
//    )
//""")
//    List<Ship> findActiveShipsWithoutRoute();

//    @Query("""
//    SELECT s FROM Ship s
//    LEFT JOIN Route r ON s.id = r.ship.id
//    WHERE s.state = 'Active' AND r.id IS NULL
//""")
//    List<Ship> findActiveShipsWithoutRoute();

//    @Query(value = """
//    SELECT s.* FROM ship s
//    WHERE s.state = 'Active'
//    EXCEPT
//    SELECT s.* FROM ship s
//    JOIN route r ON r.ship_id = s.id
//""", nativeQuery = true)
//    List<Ship> findActiveShipsWithoutRoute();

    @Query("""
    SELECT s FROM Ship s
    WHERE s.state = 'Active' AND NOT EXISTS (
        SELECT r FROM Route r WHERE r.ship = s
    )
""")
    List<Ship> findActiveShipsWithoutRoute(); //best choice for JPQL



}


