package com.hibernate.jpa.repository;

import com.hibernate.jpa.domain.ClientSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientSessionRepository extends JpaRepository<ClientSession, Long> {
}
