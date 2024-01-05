package com.assurance.web;

import com.assurance.dto.AssuranceCreateDTO;
import com.assurance.dto.ApiResponse;
import com.assurance.dto.AssuranceDTO;
import com.assurance.dto.AssuranceUpdateDTO;
import com.assurance.exception.AssuranceAlreadyExistsException;
import com.assurance.exception.AssuranceNotFoundException;
import com.assurance.service.AssuranceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assurance")
@AllArgsConstructor
public class AssuranceController {

    private final AssuranceService assuranceService;

    private final ModelMapper modelMapper;




    @GetMapping
    public ResponseEntity<?> getAllAssurances() {
        try {
            List<AssuranceDTO> assurances = assuranceService.getAllAssurances();
            return new ResponseEntity<>(assurances, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return a generic error message for the client
            String errorMessage = "Internal server error occurred.";
            ApiResponse errorResponse = new ApiResponse(errorMessage);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getAssuranceById(@PathVariable String id) {
        try {
            Optional<AssuranceDTO> assuranceOptional = assuranceService.getAssuranceById(id);

            if (assuranceOptional.isPresent()) {
                AssuranceDTO assuranceDTO = assuranceOptional.get();
                return new ResponseEntity<>(assuranceDTO, HttpStatus.OK);
            } else {
                String notFoundMessage = "Assurance not found for id: " + id;
                ApiResponse apiResponse = new ApiResponse(notFoundMessage);
                return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return a generic error message for the client
            String errorMessage = "Internal server error occurred.";
            ApiResponse errorResponse = new ApiResponse(errorMessage);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @PostMapping
    public ResponseEntity<ApiResponse> createAssurance(@Valid @RequestBody AssuranceCreateDTO assuranceCreateDTO) {
        try {
            // Attempt to save the assurance
            Optional<AssuranceCreateDTO> createdAssuranceOptional = assuranceService.saveAssurance(assuranceCreateDTO);

            // Check if the creation was successful
            if (createdAssuranceOptional.isPresent()) {
                String successMessage = "Assurance created successfully";
                ApiResponse apiResponse = new ApiResponse(successMessage);
                return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
            } else {
                // Handle the case where the creation fails
                String errorMessage = "Failed to create assurance";
                ApiResponse apiResponse = new ApiResponse(errorMessage);
                return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (AssuranceAlreadyExistsException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return a specific error message for the client
            String errorMessage = "Assurance already exists for this vihecule.";
            ApiResponse apiResponse = new ApiResponse(errorMessage);
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return a generic error message for the client
            String errorMessage = "Internal server error occurred.";
            ApiResponse apiResponse = new ApiResponse(errorMessage);
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateAssurance(@PathVariable String id, @RequestBody AssuranceUpdateDTO updatedAssuranceCreateDTO) {
        try {
            AssuranceDTO updatedAssuranceDTO = assuranceService.updateAssurance(id, updatedAssuranceCreateDTO);
            String successMessage = "Assurance updated successfully";
            ApiResponse apiResponse = new ApiResponse(successMessage);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (AssuranceNotFoundException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return a not found response for the client
            String errorMessage = "Assurance not found for id: " + id;
            ApiResponse apiResponse = new ApiResponse(errorMessage);
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return a generic error message for the client
            String errorMessage = "Internal server error occurred.";
            ApiResponse apiResponse = new ApiResponse(errorMessage);
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
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
