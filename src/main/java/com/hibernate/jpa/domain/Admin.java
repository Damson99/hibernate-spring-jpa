package com.hibernate.jpa.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "Admin")
@Table(
        name = "admin",
        uniqueConstraints = {
                @UniqueConstraint(name = "admin_email_unique", columnNames = "email"),
        })
public class Admin
{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(
            name = "id",
            length = 36,
            columnDefinition = "varchar(36)",
            updatable = false,
            nullable = false)
    private UUID id;

    @CreationTimestamp
    @Column(
            name = "created_date",
            updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(
            name = "last_modified_date")
    private Timestamp lastModifiedDate;

    @Column(name = "first_name",
            nullable = false,
            length = 36,
            columnDefinition = "varchar(36)")
    private String firstName;

    @Column(name = "phone_number",
            nullable = false,
            length = 9,
            columnDefinition = "varchar(9)")
    private String phoneNumber;

    @Column(name = "surname",
            nullable = false,
            length = 36,
            columnDefinition = "varchar(36)")
    private String surname;

    @ManyToOne
    private Address address;

    @Column(name = "email",
            nullable = false,
            length = 36,
            columnDefinition = "varchar(36)")
    private String email;

    @Column(name = "age",
            nullable = false)
    private int age;

    @ManyToMany
    @JoinTable(
            name = "admin_roles",
            joinColumns = @JoinColumn(name = "admin_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles= new ArrayList<>();
}
