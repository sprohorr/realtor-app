package org.example.repository;

import org.example.entity.RealtyAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtyAgentRepository extends JpaRepository<RealtyAgent, Integer> {

    boolean existsRealtyAgentByName(String name);

}
