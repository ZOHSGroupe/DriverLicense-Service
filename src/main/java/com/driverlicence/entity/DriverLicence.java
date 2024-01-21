
package com.driverlicence.entity;

import com.driverlicence.enums.Status;
import com.driverlicence.enums.TypeDriverLicence;
import jakarta.persistence.*;
        import lombok.*;
        import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "driver_license")
public class DriverLicence {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Enumerated(value = EnumType.STRING)
    TypeDriverLicence type;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Enumerated(value = EnumType.STRING)
    Status status;

    String clientId;

    String licenseNumber;

    @Temporal(TemporalType.DATE)
    Date issueDate;
    @Temporal(TemporalType.DATE)
    Date expirationDate;

}
