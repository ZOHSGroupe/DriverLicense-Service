package com.assurance.repository;

import com.assurance.entity.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverLicenseRepository extends JpaRepository<DriverLicense,String> {
}
