package com.hibernate.jpa.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "ClientAction")
@Table(
        name = "client_action")
public class ClientAction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id",
            length = 36,
            columnDefinition = "varchar(36)",
            updatable = false,
            nullable = false)
    private UUID id;

    @Column(name = "server_request")
    private long serverRequest;

    @Column(name = "server_response")
    private long serverResponse;

    @Column(name = "endpoint")
    private String endpoint;

    @ManyToOne
    private App app;
}
