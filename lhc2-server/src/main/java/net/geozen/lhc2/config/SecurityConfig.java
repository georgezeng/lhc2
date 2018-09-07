package net.geozen.lhc2.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import net.geozen.lhc2.web.filter.ErrorHandlerFilter;
import net.geozen.lhc2.web.filter.security.handler.AuthenticationLogoutHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${login.account}")
	private String username;

	@Value("${login.password}")
	private String password;

	@Value("${management.endpoints.web.base-path}")
	private String managePath;

	@Autowired
	private ErrorHandlerFilter errorHandlerFilter;

	@Autowired
	private OpenEntityManagerInViewFilter openEntityManagerInViewFilter;

	@Value("${access.control.allow.origin}")
	private String origin;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(origin));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable();
		http.csrf().disable();
		http.cors();
		http.formLogin().loginProcessingUrl("/login").permitAll().successHandler(loginLogoutHandler()).failureHandler(loginLogoutHandler());
		http.logout().logoutSuccessHandler(loginLogoutHandler());
		http.userDetailsService(getUserDetailsService());
		http.rememberMe().alwaysRemember(true).userDetailsService(getUserDetailsService());
		http.authorizeRequests().antMatchers(managePath + "/health").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.exceptionHandling().accessDeniedHandler(loginLogoutHandler()).authenticationEntryPoint(loginLogoutHandler());
		http.addFilterBefore(errorHandlerFilter, ChannelProcessingFilter.class);
		http.addFilterAfter(openEntityManagerInViewFilter, ErrorHandlerFilter.class);
	}

	@Autowired
	private AuthenticationLogoutHandler loginLogoutHandler;

	protected AuthenticationLogoutHandler loginLogoutHandler() {
		return loginLogoutHandler;
	}

	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder pwdEncoder;

	@PostConstruct
	public void init() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername(username).password(pwdEncoder.encode(password)).roles("AUTH_USER").build());
		userDetailsService = manager;
	}

	protected UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}
}
