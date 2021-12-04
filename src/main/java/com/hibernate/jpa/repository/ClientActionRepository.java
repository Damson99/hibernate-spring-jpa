package com.hibernate.jpa.repository;

import com.hibernate.jpa.domain.ClientAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientActionRepository extends JpaRepository<ClientAction, Long> {
}
