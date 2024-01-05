package com.assurance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString @AllArgsConstructor @NoArgsConstructor
public class DriverLicense {
    @Id
    String id;
    String licenseNumber;
    @Temporal(TemporalType.DATE)
    Date issueDate;
    @Temporal(TemporalType.DATE)
    Date expirationDate;
    //@Enumerated(value = EnumType.STRING)
    //TypeDriverLicense type;
    String type;
    //@Enumerated(value = EnumType.STRING)
    //Status status;
    String status;
    @Temporal(TemporalType.DATE)
    Date dateCreation;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Client client;
    @PrePersist
    protected void onCreate() {
        // Set the default value for the 'date' field to the current date
        this.dateCreation = new Date();
    }
}
