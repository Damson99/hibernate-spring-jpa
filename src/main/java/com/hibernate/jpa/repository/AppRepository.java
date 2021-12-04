package com.hibernate.jpa.repository;

import com.hibernate.jpa.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {
}
