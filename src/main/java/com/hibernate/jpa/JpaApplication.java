package com.hibernate.jpa;

import com.hibernate.jpa.domain.Address;
import com.hibernate.jpa.domain.Admin;
import com.hibernate.jpa.domain.Role;
import com.hibernate.jpa.repository.AddressRepository;
import com.hibernate.jpa.repository.AdminRepository;
import com.hibernate.jpa.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AdminRepository userRepository, RoleRepository roleRepository,
										AddressRepository addressRepository){
		return args -> {
			Role adminRole= new Role();
			adminRole.setName("admin");
			roleRepository.save(adminRole);

			Address address= Address.builder()
					.postalCode(12354)
					.country("Poland")
					.city("Warsaw")
					.street("Street")
					.apartmentNumber(3)
					.localNumber(45)
					.build();
			addressRepository.save(address);

			HashSet<Role> roles= new HashSet<>();
			roles.add(adminRole);
			Admin admin = Admin.builder()
					.age(20)
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.email("damian@gmail.com")
					.firstName("Damian")
					.address(address)
					.phoneNumber("777888999")
					.surname("Wieczorek")
					.roles(roles)
					.build();

			System.out.println(userRepository.save(admin).toString());
		};
	}
}
