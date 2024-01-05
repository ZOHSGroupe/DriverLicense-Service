package com.assurance.dto;
import com.assurance.enums.Status;
import com.assurance.enums.TypeAssurance;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AssuranceUpdateDTO {
    private TypeAssurance type;
    private Status status;
    private Double price;
}
