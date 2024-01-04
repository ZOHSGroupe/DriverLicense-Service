package com.assurance.service;

import com.assurance.dto.AssuranceCreateDTO;
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

    public AssuranceCreateDTO saveAssurance(AssuranceCreateDTO assuranceCreateDTO) {
        Assurance assurance = modelMapper.map(assuranceCreateDTO, Assurance.class);
        // You can perform additional business logic here before saving
        assurance = assuranceRepository.save(assurance);
        return modelMapper.map(assurance, AssuranceCreateDTO.class);
    }

    public List<AssuranceCreateDTO> getAllAssurances() {
        List<Assurance> assurances = assuranceRepository.findAll();
        return assurances.stream()
                .map(assurance -> modelMapper.map(assurance, AssuranceCreateDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<AssuranceCreateDTO> getAssuranceById(String id) {
        return assuranceRepository.findById(id)
                .map(assurance -> modelMapper.map(assurance, AssuranceCreateDTO.class));
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


    public AssuranceCreateDTO updateAssurance(String id, AssuranceCreateDTO updatedAssuranceCreateDTO) {
        Optional<Assurance> existingAssuranceOptional = assuranceRepository.findById(id);
        if (existingAssuranceOptional.isPresent()) {
            Assurance existingAssurance = existingAssuranceOptional.get();
            modelMapper.map(updatedAssuranceCreateDTO, existingAssurance);
            // You can perform additional business logic here before updating
            existingAssurance = assuranceRepository.save(existingAssurance);
            return modelMapper.map(existingAssurance, AssuranceCreateDTO.class);
        } else {
            // Handle not found case
            return null;
        }
    }

    public List<AssuranceCreateDTO> getAssurancesByViheculeId(String viheculeId) {
        List<Assurance> assurances = assuranceRepository.findByViheculeId(viheculeId);
        return assurances.stream()
                .map(assurance -> modelMapper.map(assurance, AssuranceCreateDTO.class))
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
