package com.client.Services;



import com.client.entity.DriverLicense;

import java.util.List;
import java.util.Optional;

public interface DriverLicenseService {

    List<DriverLicense> getAllDriverLicenses();

    Optional<DriverLicense> getDriverLicenseById(String id);

    DriverLicense saveDriverLicense(DriverLicense driverLicense);

    void deleteDriverLicense(String id);


}


