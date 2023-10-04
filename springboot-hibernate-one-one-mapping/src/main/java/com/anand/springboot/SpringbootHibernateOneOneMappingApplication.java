package com.anand.springboot;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anand.springboot.entity.Gender;
import com.anand.springboot.entity.User;
import com.anand.springboot.entity.UserProfile;
import com.anand.springboot.repository.UserProfileRepository;
import com.anand.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringbootHibernateOneOneMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneOneMappingApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// user object
		User user = new User();
		user.setName("Anand");
		user.setEmail("anand@gmail.com");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Noida");
		userProfile.setBirthOfDate(LocalDate.of(1998, 11, 28));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("8709986365");
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		userRepository.save(user);
	}

}
