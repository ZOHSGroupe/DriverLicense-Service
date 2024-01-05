package com.assurance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Assurance {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    String id;

    //@Enumerated(value = EnumType.STRING)
    //TypeAssurance type;

    String type;

    @Temporal(TemporalType.DATE)
    Date dateCreate;

    //@Enumerated(value = EnumType.STRING)
    //Status status;

    String status;

    @OneToOne
    @JsonBackReference
    Vihecule vihecule;

    String price;

    @PrePersist
    protected void onCreate() {
        // Set the default value for the 'date' field to the current date
        this.dateCreate = new Date();
    }
}
