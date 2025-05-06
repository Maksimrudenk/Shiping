package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.shiping.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
