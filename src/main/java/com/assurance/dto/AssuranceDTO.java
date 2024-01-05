package com.assurance.dto;


import com.assurance.enums.Status;
import com.assurance.enums.TypeAssurance;
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
public class AssuranceDTO {

    private String id;
    private TypeAssurance type;

    @Temporal(TemporalType.DATE)
    private LocalDate dateCreate;

    private Status status;
    private String viheculeId;
    private Double price;

}
