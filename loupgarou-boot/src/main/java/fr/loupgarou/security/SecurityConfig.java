package fr.loupgarou.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/assets/**").permitAll()
		.antMatchers("/api/**").permitAll()
		.antMatchers("/inscription").permitAll()
		.antMatchers("/**").hasAnyRole("ADMIN", "USER")
		.and()
		.formLogin()
		.loginPage("/index")
		.loginProcessingUrl("/perform_login")
		.defaultSuccessUrl("/accueil", true)
		.failureUrl("/index?error=true")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/deconnexion")
		.logoutSuccessUrl("/accueil")
		.permitAll()
		.and().csrf().ignoringAntMatchers("/api/**");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//		System.out.println(new BCryptPasswordEncoder().encode("0000"));
	return new BCryptPasswordEncoder();
	}
}