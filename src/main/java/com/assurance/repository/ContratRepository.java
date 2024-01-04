package com.assurance.repository;

import com.assurance.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,String> {
}
