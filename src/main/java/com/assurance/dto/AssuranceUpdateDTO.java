package com.assurance.dto;
import lombok.Data;

import java.util.Date;


@Data
public class AssuranceUpdateDTO {
    private String type;
    private String status;
    private String price;
}
