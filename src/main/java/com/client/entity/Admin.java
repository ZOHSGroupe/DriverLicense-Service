package com.client.entity;

import com.client.entity.enumerate.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Admin{
    @Id
    String id;
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

}
