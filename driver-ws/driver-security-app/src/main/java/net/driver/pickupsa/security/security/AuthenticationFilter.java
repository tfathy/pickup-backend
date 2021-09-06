package net.driver.pickupsa.security.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import net.driver.pickupsa.security.model.LoginRequestModel;
import net.driver.pickupsa.security.model.UserDto;
import net.driver.pickupsa.security.service.IUserAccount;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private Environment environment;
	private IUserAccount userService;

	public AuthenticationFilter(IUserAccount userService, Environment environment,
			AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.environment = environment;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			System.out.println(">>>>>>attemptAuthentication is called");
			LoginRequestModel creds = new ObjectMapper().readValue(request.getInputStream(), LoginRequestModel.class);

			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String userName = ((User) authResult.getPrincipal()).getUsername();
		UserDto userDetails = userService.getUserDetailsByEmail(userName);
		System.out.println("userDetails.getAccountStatus()=" + userDetails.getAccountStatus());
		String token = Jwts.builder().setSubject(userDetails.getUserId())
				.setExpiration(new Date(
						System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiration_time"))))
				.signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret")).compact();
		response.addHeader("email", userDetails.getEmail());
		response.addHeader("token", token);
		response.addHeader("userId", String.valueOf(userDetails.getUserId()));
		response.addHeader("userType", String.valueOf(userDetails.getUserType()));
		response.addHeader("accountStatus", userDetails.getAccountStatus());
		if (userDetails.getMember() != null) {
			response.addHeader("driverNameEn", String.valueOf(userDetails.getMember().getFullNameEn()));
			response.addHeader("driverNameAr", String.valueOf(userDetails.getMember().getFullNameAr()));
			response.addHeader("terminatedFlag", String.valueOf(userDetails.getMember().getTerminatedFlag()));
			response.addHeader("driverId", String.valueOf(userDetails.getMember().getId()));
			response.addHeader("spNameAr", String.valueOf(userDetails.getMember().getSp().getCompanyNameAr()));
			response.addHeader("spNameEn", String.valueOf(userDetails.getMember().getSp().getCompanyNameEn()));
			response.addHeader("spContactPersonEmail",
					String.valueOf(userDetails.getMember().getSp().getContactPersonEmail()));
			response.addHeader("teamDescEn", String.valueOf(userDetails.getMember().getTeam().getDescEn()));
			response.addHeader("vclSizeDescEn", String.valueOf(userDetails.getMember().getTeam().getGnVehicle().getVehicleSize().getDescEn()));
			response.addHeader("vclSizeId", String.valueOf(userDetails.getMember().getTeam().getGnVehicle().getVehicleSize().getId()));
			
		}

	}
}
