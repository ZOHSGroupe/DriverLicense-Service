package com.driverlicence.service;

import com.driverlicence.dto.DriverLicenceCreateDTO;
import com.driverlicence.dto.DriverLicenceDTO;
import com.driverlicence.dto.DriverLicenceUpdateDTO;
import com.driverlicence.entity.DriverLicence;
import com.driverlicence.enums.Status;
import com.driverlicence.exception.ClientNotExistsException;
import com.driverlicence.exception.DriverLicenceAlreadyExistsException;
import com.driverlicence.exception.DriverLicenceNotFoundException;
import com.driverlicence.exception.NotValidDriverLicense;
import com.driverlicence.repository.DriverLicenceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DriverLicenceService {

    private final DriverLicenceRepository driverLicenceRepository;
    private final ModelMapper modelMapper;



    public Optional<DriverLicenceCreateDTO> saveDriverLicence(DriverLicenceCreateDTO driverLicenceCreateDTO) {
        String licenseNumber = driverLicenceCreateDTO.getLicenseNumber();
        List<DriverLicence> driverLicensesByLicenseNumber = driverLicenceRepository.findByLicenseNumberAndStatus(licenseNumber, Status.Active);
        Date currentDate = new Date(); // Get current date
        Date licenseExpirationDate = driverLicenceCreateDTO.getExpirationDate();
        if (currentDate.after(licenseExpirationDate)) {
            throw new NotValidDriverLicense("This driver license is already expired in " + licenseExpirationDate);
        }
        // Check if an assurance already exists for the specified viheculeId
        if (!driverLicensesByLicenseNumber.isEmpty()) {

            for (var driverLicense : driverLicensesByLicenseNumber) {
                Date licenseExpirationDateTemp = driverLicense.getExpirationDate();

                // Compare the current date with the date of creation
                if (licenseExpirationDateTemp.after(licenseExpirationDate)) {
                    throw new DriverLicenceAlreadyExistsException("A valid Driver License already exists by License Number :  " + licenseNumber);
                }
            }
        }
        // Continue with the rest of your logic
        DriverLicence driverLicence = modelMapper.map(driverLicenceCreateDTO, DriverLicence.class);
        driverLicence.setDateCreation(new Date());
        // You can perform additional business logic here before saving
        try {
            driverLicence = driverLicenceRepository.save(driverLicence);
            DriverLicenceCreateDTO createdAssuranceDTO = modelMapper.map(driverLicence, DriverLicenceCreateDTO.class);
            return Optional.of(createdAssuranceDTO);
        } catch (Exception e) {
            // Log the exception or perform any necessary cleanup
            throw new ClientNotExistsException("Client does not exist with id : "+driverLicenceCreateDTO.getClientId()+" for Driver License creation.");
        }
    }


    public List<DriverLicenceDTO> getAllADriverLicenses() {
        List<DriverLicence> driverLicences = driverLicenceRepository.findAll();
        return driverLicences.stream()
                .map(driverLicence -> modelMapper.map(driverLicence, DriverLicenceDTO.class))
                .collect(Collectors.toList());
    }

    public List<DriverLicenceDTO> getDriverLicensesByIdClient(String clientId) {
        List<DriverLicence> driverLicences = driverLicenceRepository.findByClientId(clientId);
        return driverLicences.stream()
                .map(driverLicence -> modelMapper.map(driverLicence, DriverLicenceDTO.class))
                .collect(Collectors.toList());
    }

    public List<DriverLicenceDTO> getValidDriverLicensesByClientId(String clientId) {
        List<DriverLicence> driverLicences = driverLicenceRepository.findByClientId(clientId);
        List<DriverLicence> validDriverLicenses = new ArrayList<>();
        Date currentDate = new Date(); // Get current date
        for (var driverLicense : driverLicences) {
            if (currentDate.before(driverLicense.getExpirationDate())) {
                validDriverLicenses.add(driverLicense);
            }
        }
        return validDriverLicenses.stream()
                .map(driverLicence -> modelMapper.map(driverLicence, DriverLicenceDTO.class))
                .collect(Collectors.toList());
    }


    public List<DriverLicenceDTO> getInValidDriverLicensesByIdClient(String clientId) {
        List<DriverLicence> driverLicences = driverLicenceRepository.findByClientId(clientId);
        List<DriverLicence> validDriverLicenses = new ArrayList<>();
        Date currentDate = new Date(); // Get current date
        for (var driverLicense : driverLicences) {
            if (currentDate.after(driverLicense.getExpirationDate())) {
                validDriverLicenses.add(driverLicense);
            }
        }
        return validDriverLicenses.stream()
                .map(driverLicence -> modelMapper.map(driverLicence, DriverLicenceDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<DriverLicenceDTO> getDriverLicenseById(String id) {
        return driverLicenceRepository.findById(id)
                .map(driverLicence -> modelMapper.map(driverLicence, DriverLicenceDTO.class));
    }


    public boolean deleteADriverLicenseById(String id) {
        Optional<DriverLicence> existingAssurance = driverLicenceRepository.findById(id);

        if (existingAssurance.isPresent()) {
            try {
                driverLicenceRepository.deleteById(id);
                return true; // Deletion successful
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception
                return false; // Deletion failed
            }
        } else {
            return false; // Assurance not found
        }
    }


    public DriverLicenceDTO updateDriverLicense(String id, DriverLicenceUpdateDTO updateDriverLicenseDTO) {
        List<DriverLicence> existingDriverLicenseOptional = driverLicenceRepository.findByIdAndStatus(id,Status.Active);

        if (!existingDriverLicenseOptional.isEmpty()) {
            DriverLicence existingDriverLicense = existingDriverLicenseOptional.get(0);

            // Update fields if provided in the UpdateAssuranceDTO
            if (updateDriverLicenseDTO.getType() != null) {
                existingDriverLicense.setType(updateDriverLicenseDTO.getType());
            }

            if (updateDriverLicenseDTO.getStatus() != null) {
                existingDriverLicense.setStatus(updateDriverLicenseDTO.getStatus());
            }
            if (updateDriverLicenseDTO.getExpirationDate() != null) {
                existingDriverLicense.setExpirationDate(updateDriverLicenseDTO.getExpirationDate());
            }
            if (updateDriverLicenseDTO.getIssueDate() != null) {
                existingDriverLicense.setIssueDate(updateDriverLicenseDTO.getIssueDate());
            }

            // You can perform additional business logic here before updating
            existingDriverLicense = driverLicenceRepository.save(existingDriverLicense);
            return modelMapper.map(existingDriverLicense, DriverLicenceDTO.class);
        } else {
            // Handle not found case
            throw new DriverLicenceNotFoundException("Driver License not found for id: " + id);
        }
    }


    public boolean deleteDriverLicenseByclientId(String clientId) {
        List<DriverLicence> driverLicenceToDelete = driverLicenceRepository.findByClientIdAndStatus(clientId,Status.Active);
        if(driverLicenceToDelete.isEmpty()) return false;
        driverLicenceToDelete.forEach(driverLicence -> driverLicenceRepository.deleteById(driverLicence.getId()));
        return true;
    }

    // Add other methods as needed, e.g., findByType, findByStatus, etc.
}
