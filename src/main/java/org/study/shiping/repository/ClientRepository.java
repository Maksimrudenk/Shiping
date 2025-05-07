package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.shiping.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByName(String name);
}
