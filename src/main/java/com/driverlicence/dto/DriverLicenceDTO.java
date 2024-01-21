package com.driverlicence.dto;


import com.driverlicence.enums.Status;
import com.driverlicence.enums.TypeDriverLicence;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DriverLicenceDTO {

    private String id;
    private TypeDriverLicence type;

    private Date dateCreation;

    private Status status;

    private String clientId;

    private String licenseNumber;

    private Date issueDate;

    private Date expirationDate;

}
