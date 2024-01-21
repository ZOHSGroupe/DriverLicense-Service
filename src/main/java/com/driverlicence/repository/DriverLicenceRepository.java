package com.driverlicence.repository;

    import com.driverlicence.entity.DriverLicence;
    import com.driverlicence.enums.Status;
    import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverLicenceRepository extends JpaRepository<DriverLicence,String> {
    List<DriverLicence> findByClientId(String clientId);
    List<DriverLicence> findByClientIdAndStatus(String licenseNumber,Status status);
    List<DriverLicence> findByLicenseNumberAndStatus(String licenseNumber, Status status);
    List<DriverLicence> findByIdAndStatus(String id, Status status);




}
