package com.driverlicence.dto;
import com.driverlicence.enums.Status;
import com.driverlicence.enums.TypeDriverLicence;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DriverLicenceUpdateDTO {
    private Status status;
    //private String id;
    private TypeDriverLicence type;

    private Date issueDate;

    private Date expirationDate;
}
