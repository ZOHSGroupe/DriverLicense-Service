package com.client.dao;

import com.client.entity.enumerate.Status;
import com.client.entity.enumerate.TypeDriverLicense;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DriverLicenseDao {


    String licenseNumber;



    TypeDriverLicense type;
    Status status;

}
