package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.shiping.model.Ship;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}
