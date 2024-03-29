package com.pickup.security.sysowner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

import com.pickup.security.sysowner.entity.SysOwnerUser;
import com.pickup.security.sysowner.entity.shared.UserDto;
import com.pickup.security.sysowner.model.UserExistsModel;
import com.pickup.security.sysowner.repos.UserRepos;

import error.InvalidOldPasswordException;

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
		SysOwnerUser userEntity = userRepos.findByEmail(username);

		if (userEntity == null)
			throw new UsernameNotFoundException(username);
		System.out.println(">>> returned user in loadUserByUsername *******************************");
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getEncryptedPassword());
		System.out.println(userEntity.getId());
		System.out.println(userEntity.getHrEmployee());
		System.out.println("*************************************************************************");

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true,
				new ArrayList<>());
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		System.out.println("******createUser begin****** createUser returns UserDto ");
		System.out.println("****createUser accepts object of type userDetails:");
		System.out.println(userDetails);
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(encoder.encode(userDetails.getPassword()));
		String msg = "The following is your user name and temporary password. \nUsername is : " + userDetails.getEmail()
				+ "\nPassword is:" + userDetails.getPassword();
		sendSimpleMessage(userDetails.getEmail(), "PICK UP Login Account", msg);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		SysOwnerUser userEntity = modelMapper.map(userDetails, SysOwnerUser.class);
		System.out.println(userEntity.getSp());
		userRepos.save(userEntity);
		System.out.println("**************OBJECT SAVED IS userEntity:");
		System.out.println(userEntity);

		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

		return returnValue;
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		SysOwnerUser userEntity = userRepos.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return new ModelMapper().map(userEntity, UserDto.class);
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		SysOwnerUser userEntity = userRepos.findByUserId(userId);
		if (userEntity == null)
			throw new UsernameNotFoundException("User not found");

		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
		return userDto;
	}

	@Override
	public List<SysOwnerUser> findAll() {

		return this.userRepos.findAll();
	}

	private void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(this.env.getProperty("spring.mail.username"));
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public SysOwnerUser changePassword(String email, String oldpassword, String newpassword) {

		SysOwnerUser user = userRepos.findByEmail(email);
		if (user == null) {
			return null;
		}
		if (!checkIsvalidOldPassword(user, oldpassword)) {
			throw new InvalidOldPasswordException("Invalid Old Password");
		}

		user.setEncryptedPassword(encoder.encode(newpassword));
		this.userRepos.save(user);
		return user;
	}

	private boolean checkIsvalidOldPassword(final SysOwnerUser user, String oldPassword) {
		return encoder.matches(oldPassword, user.getEncryptedPassword());
	}

	@Override
	public UserExistsModel RestPassword(String email) {
		UserExistsModel entity = null;
		SysOwnerUser user = userRepos.findByEmail(email);
		if (user == null) {
			return null;
		}
// generate random password
		String newpassword = generateRandomText(5);
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

	private String generateRandomText(int length) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
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
	public List<SysOwnerUser> findSpMembersUsers(Integer spId) {
		List<SysOwnerUser> resultList;
		Query query = em.createNamedQuery("FindMembersBySpId");
		query.setParameter(1, spId);
		resultList = query.getResultList();
		return resultList;
	}

	@Override
	public SysOwnerUser updateUserByUserId(UserDto userDto, String userId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SysOwnerUser userEntity = modelMapper.map(userDto, SysOwnerUser.class);
		userEntity.setUserId(userId);

		return userRepos.save(userEntity);
	}

	@Override
	public SysOwnerUser loadUserByCustomerId(Integer customerId) {
		SysOwnerUser entity = null;
		try {
			Query query = em.createNamedQuery("FindUserByCustomerId");
			query.setParameter(1, customerId);
			entity = (SysOwnerUser) query.getSingleResult();
		} catch (NoResultException nef) {
			System.out.println("*****************");
			System.out.println("Cannot load user info of cusotmer " + customerId);
			System.out.println("*****************");
		}
		return entity;
	}

	@Override
	public SysOwnerUser findByMemberId(Integer memberId) {
		SysOwnerUser entity = null;
		try {
			Query query = em.createNamedQuery("FindUserByMemberId");
			query.setParameter(1, memberId);
			entity = (SysOwnerUser) query.getSingleResult();
			
		}catch(NoResultException nef) {
			System.out.println("*****************");
			System.out.println("Cannot load user info of driver " + memberId);
			System.out.println("*****************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
}
