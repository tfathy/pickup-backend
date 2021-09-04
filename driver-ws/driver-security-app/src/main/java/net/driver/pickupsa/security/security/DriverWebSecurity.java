package net.driver.pickupsa.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.driver.pickupsa.security.service.IUserAccount;

@Configuration
@EnableWebSecurity
public class DriverWebSecurity extends WebSecurityConfigurerAdapter{
	private Environment env;
	private BCryptPasswordEncoder encoder;
	private IUserAccount userService;
	
	@Autowired
	public DriverWebSecurity(Environment env, BCryptPasswordEncoder encoder, IUserAccount userService) {
		this.env = env;
		this.encoder = encoder;
		this.userService = userService;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").permitAll()
		.and()
		.addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(encoder);
	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService, env, authenticationManager());		
		authenticationFilter.setFilterProcessesUrl(env.getProperty("login.url.path"));
		return authenticationFilter;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		System.out.println(">>>>>>>>>> Inside WebSecurity  config method");
		web.ignoring()
		.antMatchers(HttpMethod.POST,"driver-security-app/driver-auth");
	}
	

}
