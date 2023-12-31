package com.client.Services;



import com.client.entity.DriverLicense;
import com.client.repository.DriverLicenseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverLicenseServiceImpl implements DriverLicenseService {

    private final DriverLicenseRepository driverLicenseRepository;

    public DriverLicenseServiceImpl(DriverLicenseRepository driverLicenseRepository) {
        this.driverLicenseRepository = driverLicenseRepository;
    }

    @Override
    public List<DriverLicense> getAllDriverLicenses() {
        return driverLicenseRepository.findAll();
    }

    @Override
    public Optional<DriverLicense> getDriverLicenseById(String id) {
        return driverLicenseRepository.findById(id);
    }

    @Override
    public DriverLicense saveDriverLicense(DriverLicense driverLicense) {
        return driverLicenseRepository.save(driverLicense);
    }

    @Override
    public void deleteDriverLicense(String id) {
        driverLicenseRepository.deleteById(id);
    }


}
