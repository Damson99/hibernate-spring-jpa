package com.hibernate.jpa;

import com.hibernate.jpa.domain.Student;
import com.hibernate.jpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Student student = Student.builder()
					.age(20)
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.email("damian@gmail.com")
					.firstName("Damian")
					.surname("Wieczorek")
					.build();

			System.out.println(studentRepository.save(student).toString());
		};
	}
}
