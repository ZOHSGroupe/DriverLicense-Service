package com.assurance.controller;

import com.assurance.dto.AssuranceDTO;
import com.assurance.entity.Assurance;
import com.assurance.service.ApiResponse;
import com.assurance.service.AssuranceService;
import jakarta.validation.Valid;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {

    private final AssuranceService assuranceService;

    private final ModelMapper modelMapper;

    @Autowired
    public AssuranceController(AssuranceService assuranceService, ModelMapper modelMapper) {
        this.assuranceService = assuranceService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<AssuranceDTO>> getAllAssurances() {
        List<AssuranceDTO> assurances = assuranceService.getAllAssurances();
        return new ResponseEntity<>(assurances, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AssuranceDTO> getAssuranceById(@PathVariable String id) {
        return assuranceService.getAssuranceById(id)
                .map(assuranceDTO -> new ResponseEntity<>(assuranceDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<ApiResponse> createAssurance(@Valid @RequestBody AssuranceDTO assuranceDTO) {
        String viheculeId = assuranceDTO.getViheculeId();

        // Check if an assurance already exists for the specified viheculeId
        if (assuranceService.hasAssuranceForVihecule(viheculeId)) {
            String message = "Assurance already exists for viheculeId " + viheculeId;
            ApiResponse apiResponse = new ApiResponse(message);
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }

        AssuranceDTO createdAssurance = assuranceService.saveAssurance(assuranceDTO);
        String message = "Assurance created successfully";
        ApiResponse apiResponse = new ApiResponse(message);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AssuranceDTO> updateAssurance(
            @PathVariable String id,
            @Valid @RequestBody AssuranceDTO updatedAssuranceDTO) {
        AssuranceDTO updatedAssurance = assuranceService.updateAssurance(id, updatedAssuranceDTO);
        if (updatedAssurance != null) {
            return new ResponseEntity<>(updatedAssurance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAssurance(@PathVariable String id) {
        if(assuranceService.deleteAssuranceById(id)){
            String message = "Assurances associated with " + id + " deleted successfully";
            ApiResponse apiResponse = new ApiResponse(message);
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        String message = "Assurances associated with id " + id + " not found";
        ApiResponse apiResponse = new ApiResponse(message);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

    }

    @GetMapping("/vihecule/{viheculeId}")
    public ResponseEntity<List<AssuranceDTO>> getAssurancesByViheculeId(@PathVariable String viheculeId) {
        List<AssuranceDTO> assurances = assuranceService.getAssurancesByViheculeId(viheculeId);
        return new ResponseEntity<>(assurances, HttpStatus.OK);
    }

    @DeleteMapping("/vihecule/{viheculeId}")
    public ResponseEntity<ApiResponse> deleteAssurancesByViheculeId(@PathVariable String viheculeId) {
        if(!assuranceService.deleteAssurancesByViheculeId(viheculeId)){
            String message = "Assurances associated with viheculeId " + viheculeId + " not found";
            ApiResponse apiResponse = new ApiResponse(message);
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
        String message = "Assurances associated with viheculeId " + viheculeId + " deleted successfully";
        ApiResponse apiResponse = new ApiResponse(message);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
