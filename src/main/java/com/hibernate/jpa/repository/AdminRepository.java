package com.hibernate.jpa.repository;

import com.hibernate.jpa.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {

}
