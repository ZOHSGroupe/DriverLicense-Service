package com.client.repositor;

import com.client.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,String> {
}
