package com.driverlicence.web;

import com.driverlicence.dto.ApiResponse;
import com.driverlicence.dto.DriverLicenceCreateDTO;
import com.driverlicence.dto.DriverLicenceDTO;
import com.driverlicence.dto.DriverLicenceUpdateDTO;
import com.driverlicence.exception.ClientNotExistsException;
import com.driverlicence.exception.DriverLicenceAlreadyExistsException;
import com.driverlicence.exception.DriverLicenceNotFoundException;
import com.driverlicence.exception.NotValidDriverLicense;
import com.driverlicence.service.DriverLicenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/driver-license")
public class DriverLicenceController {

    private final DriverLicenceService driverLicenceService;

    public DriverLicenceController(DriverLicenceService driverLicenceService) {
        this.driverLicenceService = driverLicenceService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDriverLicence(@RequestBody DriverLicenceCreateDTO driverLicenceCreateDTO) {
        try {
            DriverLicenceCreateDTO savedDriverLicence = driverLicenceService.saveDriverLicence(driverLicenceCreateDTO).orElse(null);            return ResponseEntity.status(HttpStatus.CREATED).body(savedDriverLicence);
        } catch (DriverLicenceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
        }catch (ClientNotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
        }catch (NotValidDriverLicense e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
        }
    }


    @GetMapping
    public List<DriverLicenceDTO> getAllDriverLicenses() {
        return driverLicenceService.getAllADriverLicenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriverLicenseById(@PathVariable String id) {
        Optional<DriverLicenceDTO> driverLicenseOptional = driverLicenceService.getDriverLicenseById(id);

        if (driverLicenseOptional.isPresent()) {
            return ResponseEntity.ok(driverLicenseOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Driver license not found with id: " + id));
        }
    }




    @GetMapping("/client/{clientId}")
    public List<DriverLicenceDTO> getDriverLicensesByClientId(@PathVariable String clientId) {
        return driverLicenceService.getDriverLicensesByIdClient(clientId);
    }

    @GetMapping("/valid/client/{clientId}")
    public ResponseEntity<Object> getValidDriverLicensesByClientId(@PathVariable String clientId) {
        try {
            List<DriverLicenceDTO> validDriverLicenses = driverLicenceService.getValidDriverLicensesByClientId(clientId);
            return ResponseEntity.ok(validDriverLicenses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
        }
    }



    @GetMapping("/invalid/client/{clientId}")
    public ResponseEntity<Object> getInvalidDriverLicensesByClientId(@PathVariable String clientId) {
        try {
            List<DriverLicenceDTO> invalidDriverLicenses = driverLicenceService.getInValidDriverLicensesByIdClient(clientId);
            return ResponseEntity.ok(invalidDriverLicenses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDriverLicense(@PathVariable String id,
                                                      @RequestBody DriverLicenceUpdateDTO updateDriverLicenseDTO) {
        try {
            DriverLicenceDTO updatedDriverLicense = driverLicenceService.updateDriverLicense(id, updateDriverLicenseDTO);
            return ResponseEntity.ok(updatedDriverLicense);
        } catch (DriverLicenceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDriverLicenseById(@PathVariable String id) {
        if (driverLicenceService.deleteADriverLicenseById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Driver license deleted successuflly with id : "+id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Driver licence not exist with id : "+id));
        }
    }

    @DeleteMapping("/client/{clientId}")
    public ResponseEntity<?> deleteDriverLicensesByClientId(@PathVariable String clientId) {
        if (driverLicenceService.deleteDriverLicenseByclientId(clientId)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Driver licenses deleted successuflly with id client : "+clientId));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Driver licence not exist with id client : "+clientId));
        }
    }
}
