package com.client.controller;



import com.client.entity.DriverLicense;
import com.client.Services.DriverLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class DriverLicenseController {

    private final DriverLicenseService driverLicenseService;

    @Autowired
    public DriverLicenseController(DriverLicenseService driverLicenseService) {
        this.driverLicenseService = driverLicenseService;
    }

    @GetMapping
    public List<DriverLicense> getAllDriverLicenses() {
        return driverLicenseService.getAllDriverLicenses();
    }


    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Optional<DriverLicense> getDriverLicenseById(@PathVariable String id) {
        return driverLicenseService.getDriverLicenseById(id);
    }

    @PostMapping
    public DriverLicense saveDriverLicense(@RequestBody DriverLicense driverLicense) {
        return driverLicenseService.saveDriverLicense(driverLicense);
    }



    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void deleteDriverLicense(@PathVariable String id) {
        driverLicenseService.deleteDriverLicense(id);
    }




    @RequestMapping(value="/show/{id}",method=RequestMethod.GET)
    public Optional<DriverLicense> showDriverLicenseDetails(@PathVariable String id) {
        return driverLicenseService.getDriverLicenseById(id);
    }
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public DriverLicense addDriverLicense(@RequestBody DriverLicense driverLicense) {
        return driverLicenseService.saveDriverLicense(driverLicense);
    }
}

