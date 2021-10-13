package com.hibernate.jpa.repository;

import com.hibernate.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID>
{

}
