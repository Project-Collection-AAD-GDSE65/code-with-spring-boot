package lk.ijse.gdse.aad65.HelloSpringBoot;

import lk.ijse.gdse.aad65.HelloSpringBoot.dao.UserRepo;
import lk.ijse.gdse.aad65.HelloSpringBoot.entity.Role;
import lk.ijse.gdse.aad65.HelloSpringBoot.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HelloSpringBootApplicationTests {
	@Mock
	UserRepo userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void saveUser(){
		var userEntity = new UserEntity();
		userEntity.setId(UUID.randomUUID().toString());
		userEntity.setFirstName("Kamal");
		userEntity.setLastName("Silva");
		userEntity.setEmail("kamal@gmail.com");
		userEntity.setPassword(passwordEncoder.encode("hello@11"));
		userEntity.setRole(Role.valueOf("ADMIN"));

		userRepo.save(userEntity);
		assertEquals("Kamal", userEntity.getFirstName());
	}


}
