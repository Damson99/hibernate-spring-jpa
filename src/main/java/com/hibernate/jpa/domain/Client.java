package com.hibernate.jpa.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Client")
@Table(name = "client",
        uniqueConstraints = {
                @UniqueConstraint(name = "client_username_unique", columnNames = "username")
        })
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username",
            nullable = false,
            length = 36,
            columnDefinition = "varchar(36)")
    private String username;

    @CreationTimestamp
    @Column(name = "created_date",
            updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;
}
