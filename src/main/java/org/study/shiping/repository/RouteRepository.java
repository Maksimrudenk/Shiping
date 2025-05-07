package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.study.shiping.model.Route;
import org.study.shiping.model.Ship;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByDeparture_IdAndDestination_Id(long departureId, long destinationId);
    @Query("""
    SELECT r FROM Route r 
    WHERE r.id NOT IN (
        SELECT o.route.id FROM Order o WHERE o.route IS NOT NULL
    )
""")
    List<Route> findUnusedRoutes();
}
