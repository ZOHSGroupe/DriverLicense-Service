package com.client.entity;

import com.client.entity.enumerate.Gender;
import jakarta.persistence.*;

import java.util.Date;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    String firstName;
    String lastName;
    String nationalId;
    String email;
    String city;
    @Temporal(TemporalType.DATE)
    Date birthDate;
    String nationality;
    @Enumerated(value = EnumType.STRING)
    Gender gender;
    private Date createDate;
    @Temporal(TemporalType.DATE)
    Date lastModificationDate;
    String address;

    @PrePersist
    protected void onCreate() {
        // Set the default value for the 'date' field to the current date
        this.createDate = new Date();
    }
}
