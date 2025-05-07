package org.study.shiping.service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.study.shiping.model.Port;
import org.study.shiping.model.Route;
import org.study.shiping.model.Ship;
import org.study.shiping.repository.PortRepository;
import org.study.shiping.repository.RouteRepository;
import org.study.shiping.repository.ShipRepository;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final ShipRepository shipRepository;
    private final PortRepository portRepository;

    public RouteService(RouteRepository routeRepository, ShipRepository shipRepository, PortRepository portRepository) {
        this.routeRepository = routeRepository;
        this.shipRepository = shipRepository;
        this.portRepository = portRepository;
    }

    public Route getRoute(long departureId, long destinationId) {

        List<Route> existingRoutes = routeRepository.findByDeparture_IdAndDestination_Id(departureId, destinationId);
        if (!existingRoutes.isEmpty()) {
            return existingRoutes.get(0);
        }

        List<Ship> activeShips = shipRepository.findActiveShipsWithoutRoute();
        if (!activeShips.isEmpty()) {
            Ship ship = activeShips.get(0);
            Port departure = portRepository.findById(departureId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid departureId"));
            Port destination = portRepository.findById(destinationId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid destinationId"));
            Route newRoute = new Route();
            newRoute.setDeparture(departure);
            newRoute.setDestination(destination);
            newRoute.setShip(ship);
            newRoute.setDistance(100.0); // default value

            return routeRepository.save(newRoute);
        }

        throw new IllegalStateException("No available ships for creating a new route");
    }

    @PostConstruct
    @Transactional
    public void cleanUp(){
        List<Route> unusedRoutes = routeRepository.findUnusedRoutes();
        routeRepository.deleteAll(unusedRoutes);
    }


}
