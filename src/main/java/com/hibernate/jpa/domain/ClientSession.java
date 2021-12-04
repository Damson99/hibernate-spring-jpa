package com.hibernate.jpa.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "ClientSession")
@Table(
        name = "client_session")
public class ClientSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "created_date",
            updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;

    @Column(name = "session_start")
    private long sessionStart;

    @Column(name = "session_end")
    private long sessionEnd;

    @Column(name = "screen_resolution_x")
    private int screenResolutionX;

    @Column(name = "screen_resolution_y")
    private int screenResolutionY;

    @Column(name = "address_ip")
    private String addressIp;

    @ManyToMany
    private Collection<ClientAction> clientActions;

    @ManyToOne
    private Client client;
}
