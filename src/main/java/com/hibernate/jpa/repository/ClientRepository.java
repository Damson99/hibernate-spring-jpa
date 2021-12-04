package com.hibernate.jpa.repository;

import com.hibernate.jpa.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
