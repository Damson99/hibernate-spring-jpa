package com.hibernate.jpa.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "ClientAction")
@Table(
        name = "client_action")
public class ClientAction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "created_date",
            updatable = false)
    private Timestamp createdDate;

    @Column(name = "server_request")
    private long serverRequestTime;

    @Column(name = "server_response")
    private long serverResponseTime;

    @Column(name = "endpoint")
    private String endpoint;

    @ManyToOne
    private App app;
}
