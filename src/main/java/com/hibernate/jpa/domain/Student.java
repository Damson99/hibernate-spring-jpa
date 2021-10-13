package com.hibernate.jpa.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        })
public class Student
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
            nullable = false
    )
    protected UUID id;

    @Version
    @Column(
            name = "version"
    )
    protected Long version;

    @CreationTimestamp
    @Column(
            name = "created_date",
            updatable = false
    )
    protected Timestamp createdDate;

    @UpdateTimestamp
    @Column(
            name = "last_modified_date"
    )
    protected Timestamp lastModifiedDate;
    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;
    @Column(
            name = "surname",
            nullable = false
    )
    private String surname;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
    private int age;
}
