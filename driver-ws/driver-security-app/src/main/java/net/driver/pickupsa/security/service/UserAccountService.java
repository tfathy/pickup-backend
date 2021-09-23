package net.driver.pickupsa.security.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.driver.pickupsa.security.entity.DriverUser;
import net.driver.pickupsa.security.entity.lookup.SpMember;
import net.driver.pickupsa.security.error.InvalidOldPasswordException;
import net.driver.pickupsa.security.model.UserDto;
import net.driver.pickupsa.security.model.UserExistsModel;
import net.driver.pickupsa.security.respos.UserRepos;

@Service
public class UserAccountService implements IUserAccount {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	BCryptPasswordEncoder encoder;
	UserRepos userRepos;
	private JavaMailSender emailSender;
	private Environment env;
	private EntityManager em;

	public UserAccountService() {
	}

	@Autowired
	public UserAccountService(UserRepos repos, BCryptPasswordEncoder encoder, JavaMailSender emailSender,
			Environment env, EntityManager em) {
		this.encoder = encoder;
		this.userRepos = repos;
		this.emailSender = emailSender;
		this.env = env;
		this.em = em;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DriverUser userEntity = userRepos.findByEmail(username);

		if (userEntity == null || !userEntity.getUserType().equals("SP_MEMBER"))
			throw new UsernameNotFoundException(username);

		System.out.println(">>> returned user in loadUserByUsername of type driver *******************************");
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getEncryptedPassword());
		System.out.println(userEntity.getId());
		System.out.println(userEntity.getMember());
		System.out.println("*************************************************************************");

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true,
				new ArrayList<>());

	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		DriverUser userEntity = userRepos.findByEmail(email);

		if (userEntity == null ||  !userEntity.getUserType().equals("SP_MEMBER"))
			throw new UsernameNotFoundException(email);
		
		// check if the user is a manager for a team
		if(userEntity.getMember() == null)
			throw new UsernameNotFoundException(email);
		
		SpMember member = userEntity.getMember();
		if(member.getTerminatedFlag().equals("Y"))
			throw new UsernameNotFoundException(email);

		return new ModelMapper().map(userEntity, UserDto.class);
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		DriverUser userEntity = userRepos.findByUserId(userId);
		if (userEntity == null || !userEntity.getUserType().equals("SP_MEMBER"))
			throw new UsernameNotFoundException("User not found");

		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
		return userDto;
	}

	@Override
	public DriverUser changePassword(String email, String oldpassword, String newpassword) {
		DriverUser user = userRepos.findByEmail(email);
		if (user == null || !user.getUserType().equals("SP_MEMBER")) {
			return null;
		}
		if (!checkIsvalidOldPassword(user, oldpassword)) {
			throw new InvalidOldPasswordException("Invalid Old Password");
		}

		user.setEncryptedPassword(encoder.encode(newpassword));
		this.userRepos.save(user);
		return user;
	}

	@Override
	public UserExistsModel RestPassword(String email) {

		UserExistsModel entity = null;
		DriverUser user = userRepos.findByEmail(email);
		if (user == null || !user.getUserType().equals("SP_MEMBER")) {
			return null;
		}
		String newpassword = generateRandomText(4);
		// send it to user email
		sendSimpleMessage(user.getEmail(), "Pickup Application : Password rest",
				"Your password has been rest.\nYour new password is " + newpassword);
		// encrypt the password and update the entity
		user.setEncryptedPassword(encoder.encode(newpassword));
		this.userRepos.save(user);
		// return an object of type UserExistsModel
		entity = new UserExistsModel(user.getEmail());
		return entity;

	}

	private void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(this.env.getProperty("spring.mail.username"));
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	private boolean checkIsvalidOldPassword(final DriverUser user, String oldPassword) {
		return encoder.matches(oldPassword, user.getEncryptedPassword());
	}

	private String generateRandomText(int length) {
		String SALTCHARS = "0123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() <= length) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	@Override
	public DriverUser findByUserId(String userid) {
		Optional<DriverUser> result = Optional.of(userRepos.findByUserId(userid));
		DriverUser entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public DriverUser findByEmail(String email) {
		return userRepos.findByEmail(email);
	}

	@Override
	public DriverUser update(DriverUser driverUser, String userId) {	
		driverUser.setUserId(userId);
		return this.userRepos.save(driverUser);
	}

	

}
