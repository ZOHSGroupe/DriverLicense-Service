package com.assurance.entity;

import com.assurance.enums.Status;
import com.assurance.enums.TypeAssurance;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;


@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Assurance {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Enumerated(value = EnumType.STRING)
    TypeAssurance type;

    @Temporal(TemporalType.DATE)
    private LocalDate dateCreate;

    @Enumerated(value = EnumType.STRING)
    Status status;

    String viheculeId;

    Double price;
}
