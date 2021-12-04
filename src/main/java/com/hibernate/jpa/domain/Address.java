package com.hibernate.jpa.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "Address")
@Table(
        name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(
            name = "created_date",
            updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(
            name = "last_modified_date")
    private Timestamp lastModifiedDate;

    @Column(name = "postal_code",
            nullable = false,
            length = 5)
    private int postalCode;

    @Column(name = "country",
            nullable = false,
            length = 36,
            columnDefinition = "varchar(36)")
    private String country;

    @Column(name = "city",
            nullable = false,
            length = 36,
            columnDefinition = "varchar(36)")
    private String city;

    @Column(name = "street",
            nullable = false,
            length = 36,
            columnDefinition = "varchar(36)")
    private String street;

    @Column(name = "apartment_number",
            nullable = false,
            length = 5)
    private int apartmentNumber;

    @Column(name = "local_number",
            nullable = false,
            length = 5)
    private int localNumber;
}
