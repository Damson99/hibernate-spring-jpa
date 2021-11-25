package com.hibernate.jpa.repository;

import com.hibernate.jpa.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
