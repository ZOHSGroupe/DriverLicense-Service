package com.assurance.dto;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AssuranceDTO {

    private String id;
    private String type;

    @Temporal(TemporalType.DATE)
    private Date dateCreate;

    private String status;
    private String viheculeId;
    private String price;

}
