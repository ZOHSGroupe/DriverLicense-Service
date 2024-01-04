package com.assurance.dto;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class AssuranceCreateDTO {

    //private String id;
    private String type;

    @Temporal(TemporalType.DATE)
    private Date dateCreate;

    private String status;
    private String viheculeId;
    private String price;

}
