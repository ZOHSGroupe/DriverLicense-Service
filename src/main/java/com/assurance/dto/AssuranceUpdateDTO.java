package com.assurance.dto;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AssuranceUpdateDTO {
    private String type;
    private String status;
    private String price;
}
