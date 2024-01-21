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
public class DriverLicenceCreateDTO {

    //private String id;
    TypeDriverLicence type;

    @Enumerated(value = EnumType.STRING)
    Status status;

    String clientId;

    String licenseNumber;

    Date issueDate;

    Date expirationDate;

}
