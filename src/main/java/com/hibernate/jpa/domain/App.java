package com.hibernate.jpa.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "App")
@Table(
        name = "app",
        uniqueConstraints = {
                @UniqueConstraint(name = "app_name_unique", columnNames = "name"),
        })
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",
            nullable = false,
            length = 36,
            columnDefinition = "varchar(36)")
    private String name;

    @OneToMany
    private Collection<ClientSession> clientSessions = new ArrayList<>();

    @CreationTimestamp
    @Column(
            name = "created_date",
            updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(
            name = "last_modified_date")
    private Timestamp lastModifiedDate;
}
