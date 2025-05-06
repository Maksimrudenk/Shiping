package org.study.shiping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.shiping.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByName(String name);
}
