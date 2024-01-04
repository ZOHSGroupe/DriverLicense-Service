package com.assurance.service;

import com.assurance.dto.AssuranceDTO;
import com.assurance.entity.Assurance;
import com.assurance.repository.AssuranceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssuranceService {

    private final AssuranceRepository assuranceRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AssuranceService(AssuranceRepository assuranceRepository, ModelMapper modelMapper) {
        this.assuranceRepository = assuranceRepository;
        this.modelMapper = modelMapper;
    }

    public AssuranceDTO saveAssurance(AssuranceDTO assuranceDTO) {
        Assurance assurance = modelMapper.map(assuranceDTO, Assurance.class);
        // You can perform additional business logic here before saving
        assurance = assuranceRepository.save(assurance);
        return modelMapper.map(assurance, AssuranceDTO.class);
    }

    public List<AssuranceDTO> getAllAssurances() {
        List<Assurance> assurances = assuranceRepository.findAll();
        return assurances.stream()
                .map(assurance -> modelMapper.map(assurance, AssuranceDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<AssuranceDTO> getAssuranceById(String id) {
        return assuranceRepository.findById(id)
                .map(assurance -> modelMapper.map(assurance, AssuranceDTO.class));
    }

    public boolean deleteAssuranceById(String id) {
        Optional<Assurance> existingAssurance = assuranceRepository.findById(id);

        if (existingAssurance.isPresent()) {
            try {
                assuranceRepository.deleteById(id);
                return true; // Deletion successful
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception
                return false; // Deletion failed
            }
        } else {
            return false; // Assurance not found
        }
    }


    public AssuranceDTO updateAssurance(String id, AssuranceDTO updatedAssuranceDTO) {
        Optional<Assurance> existingAssuranceOptional = assuranceRepository.findById(id);
        if (existingAssuranceOptional.isPresent()) {
            Assurance existingAssurance = existingAssuranceOptional.get();
            modelMapper.map(updatedAssuranceDTO, existingAssurance);
            // You can perform additional business logic here before updating
            existingAssurance = assuranceRepository.save(existingAssurance);
            return modelMapper.map(existingAssurance, AssuranceDTO.class);
        } else {
            // Handle not found case
            return null;
        }
    }

    public List<AssuranceDTO> getAssurancesByViheculeId(String viheculeId) {
        List<Assurance> assurances = assuranceRepository.findByViheculeId(viheculeId);
        return assurances.stream()
                .map(assurance -> modelMapper.map(assurance, AssuranceDTO.class))
                .collect(Collectors.toList());
    }

    public boolean deleteAssurancesByViheculeId(String viheculeId) {
        List<Assurance> assurancesToDelete = assuranceRepository.findByViheculeId(viheculeId);
        if(assurancesToDelete.isEmpty()) return false;
        assurancesToDelete.forEach(assurance -> assuranceRepository.deleteById(assurance.getId()));
        return true;
    }
    public boolean hasAssuranceForVihecule(String viheculeId) {
        List<Assurance> existingAssurance = assuranceRepository.findByViheculeId(viheculeId);
        return !existingAssurance.isEmpty();
    }

    // Add other methods as needed, e.g., findByType, findByStatus, etc.
}
