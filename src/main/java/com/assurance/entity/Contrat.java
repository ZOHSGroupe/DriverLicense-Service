package com.assurance.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
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
