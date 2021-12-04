package com.hibernate.jpa;

import com.hibernate.jpa.domain.*;
import com.hibernate.jpa.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AdminRepository adminRepository, RoleRepository roleRepository,
										AddressRepository addressRepository, AppRepository appRepository,
										ClientActionRepository clientActionRepository, ClientRepository clientRepository,
										ClientSessionRepository clientSessionRepository){
		return args -> {

//			ROLE
			Role adminRole= new Role();
			adminRole.setName("admin");
			roleRepository.save(adminRole);

//			ADDRESS
			Address address= Address.builder()
					.postalCode(12354)
					.country("Poland")
					.city("Warsaw")
					.street("Street")
					.apartmentNumber(3)
					.localNumber(45)
					.build();
			addressRepository.save(address);

//			ADMIN
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

			adminRepository.save(admin);

//			APP
			App jira= App.builder()
					.name("Jira")
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.build();

			App confluent= App.builder()
					.name("Confluent")
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.build();

			appRepository.save(jira);
			appRepository.save(confluent);

//			CLIENT
			Client client1= Client.builder()
					.username("clientA")
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.build();

			Client client2= Client.builder()
					.username("clientB")
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.build();

			Client client3= Client.builder()
					.username("clientC")
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.build();

			clientRepository.save(client1);
			clientRepository.save(client2);
			clientRepository.save(client3);

//			CLIENT ACTION
			ClientAction clientAction1= ClientAction.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.serverRequestTime(8934)
					.serverResponseTime(9032)
					.endpoint("/api/v2/dashboard")
					.app(jira)
					.build();

			ClientAction clientAction2= ClientAction.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.serverRequestTime(500)
					.serverResponseTime(2352)
					.endpoint("/api/v2/dashboard")
					.app(jira)
					.build();

			ClientAction clientAction3= ClientAction.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.serverRequestTime(644)
					.serverResponseTime(6752)
					.endpoint("/api/v3/task")
					.app(confluent)
					.build();

			ClientAction clientAction4= ClientAction.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.serverRequestTime(1235)
					.serverResponseTime(1908)
					.endpoint("/api/v2/user")
					.app(jira)
					.build();

			ClientAction clientAction5= ClientAction.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.serverRequestTime(1236)
					.serverResponseTime(6342)
					.endpoint("/api/v2/user/3127554")
					.app(confluent)
					.build();

			ClientAction clientAction6= ClientAction.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.serverRequestTime(1236)
					.serverResponseTime(6342)
					.endpoint("/api/v2/login")
					.app(jira)
					.build();

			ClientAction clientAction7= ClientAction.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.serverRequestTime(1236)
					.serverResponseTime(6342)
					.endpoint("/api/v2/settings")
					.app(confluent)
					.build();

			clientActionRepository.save(clientAction1);
			clientActionRepository.save(clientAction2);
			clientActionRepository.save(clientAction3);
			clientActionRepository.save(clientAction4);
			clientActionRepository.save(clientAction5);
			clientActionRepository.save(clientAction6);
			clientActionRepository.save(clientAction7);


//			CLIENT SESSION
			ClientSession clientSession1= ClientSession.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.sessionStart(System.currentTimeMillis())
					.sessionEnd(System.currentTimeMillis()+ 15_000)
					.screenResolutionX(1920)
					.screenResolutionY(1080)
					.addressIp("192.168.5.123")
					.clientActions(Arrays.asList(clientAction1, clientAction2, clientAction4))
					.client(client1)
					.build();

			ClientSession clientSession2= ClientSession.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.sessionStart(System.currentTimeMillis())
					.sessionEnd(System.currentTimeMillis()+ 21_321)
					.screenResolutionX(1920)
					.screenResolutionY(1080)
					.addressIp("192.168.5.557")
					.clientActions(Arrays.asList(clientAction7, clientAction2, clientAction5))
					.client(client3)
					.build();

			ClientSession clientSession3= ClientSession.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.sessionStart(System.currentTimeMillis())
					.sessionEnd(System.currentTimeMillis()+ 1_000)
					.screenResolutionX(1920)
					.screenResolutionY(1080)
					.addressIp("192.168.1.421")
					.clientActions(Arrays.asList(clientAction6, clientAction5, clientAction5))
					.client(client2)
					.build();

			ClientSession clientSession4= ClientSession.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.sessionStart(System.currentTimeMillis())
					.sessionEnd(System.currentTimeMillis())
					.screenResolutionX(1920)
					.screenResolutionY(1080)
					.addressIp("192.168.9.567")
					.clientActions(Arrays.asList(clientAction5, clientAction2, clientAction4))
					.client(client2)
					.build();

			ClientSession clientSession5= ClientSession.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.sessionStart(System.currentTimeMillis())
					.sessionEnd(System.currentTimeMillis()+ 3_243)
					.screenResolutionX(1920)
					.screenResolutionY(1080)
					.addressIp("192.168.6.677")
					.clientActions(Arrays.asList(clientAction6, clientAction2, clientAction3))
					.client(client1)
					.build();

			ClientSession clientSession6= ClientSession.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.sessionStart(System.currentTimeMillis())
					.sessionEnd(System.currentTimeMillis()+ 6_312)
					.screenResolutionX(1920)
					.screenResolutionY(1080)
					.addressIp("192.168.2.324")
					.clientActions(Arrays.asList(clientAction5, clientAction6, clientAction7))
					.client(client3)
					.build();

			ClientSession clientSession7= ClientSession.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.sessionStart(System.currentTimeMillis())
					.sessionEnd(System.currentTimeMillis()+ 15_000)
					.screenResolutionX(1920)
					.screenResolutionY(1080)
					.addressIp("192.168.4.677")
					.clientActions(Arrays.asList(clientAction3, clientAction2, clientAction5))
					.client(client2)
					.build();

			ClientSession clientSession8= ClientSession.builder()
					.createdDate(Timestamp.valueOf(LocalDateTime.now()))
					.lastModifiedDate(Timestamp.valueOf(LocalDateTime.now()))
					.sessionStart(System.currentTimeMillis())
					.sessionEnd(System.currentTimeMillis())
					.screenResolutionX(1920)
					.screenResolutionY(1080)
					.addressIp("192.168.1.562")
					.clientActions(Arrays.asList(clientAction6, clientAction2, clientAction4))
					.client(client2)
					.build();

			clientSessionRepository.save(clientSession1);
			clientSessionRepository.save(clientSession2);
			clientSessionRepository.save(clientSession3);
			clientSessionRepository.save(clientSession4);
			clientSessionRepository.save(clientSession5);
			clientSessionRepository.save(clientSession6);
			clientSessionRepository.save(clientSession7);
			clientSessionRepository.save(clientSession8);
		};
	}
}
