package com.client.entity;

import com.client.entity.enumerate.SourceLink;
import com.client.entity.enumerate.TypeLink;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "link")
public class Link {
    @Id
    String id;
    @Temporal(value = TemporalType.DATE)
    Date dateCreation;
    String link;
    @Enumerated(value = EnumType.STRING)
    TypeLink typeLink;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Client client;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Vihecule vihecule;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    DriverLicense driverLicense;
    @OneToOne
    Contrat contrat;

    /*//Withour ManyToOneT relationShip
    @Enumerated(value = EnumType.STRING)
    SourceLink sourceLink;
    String idSource;
     */
}