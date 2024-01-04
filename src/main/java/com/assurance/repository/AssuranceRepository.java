package com.assurance.repository;

import com.assurance.entity.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssuranceRepository extends JpaRepository<Assurance,String> {
    List<Assurance> findByViheculeId(String viheculeId);
}
