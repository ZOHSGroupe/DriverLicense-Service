package com.assurance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Contrat {
    @Id
    String id;
    String price;
    @Temporal(TemporalType.DATE)
    Date dateStart;//date creation contrat == date creation this block
    @Temporal(TemporalType.DATE)
    Date dateFin;
    @OneToOne
    Vihecule vihecule;
}
