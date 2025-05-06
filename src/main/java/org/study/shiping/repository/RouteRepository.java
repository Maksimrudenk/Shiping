package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.shiping.model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
