package com.pensionmanagement.authorization.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.pensionmanagement.authorization.models.UserModel;

@DataJpaTest
public class UserRepositoryTest {
	
	@MockBean
	private UserRepository userRepository ;
	
	@Test
	void testUserDaoFindByName() {
		Optional<UserModel> user1=Optional.of(new UserModel("admin","password"));
		
		when(userRepository.findByUsername("admin")).thenReturn(user1);
		assertThat(userRepository.findByUsername("admin").equals(user1));
	}

}
