package ch.swiggels.weddingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("w").password("e").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				.antMatchers("/", "/info", "/assets/**", "/article/", "/route", "/wishList", "/galery", "/images").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/console*").authenticated().and().formLogin().permitAll().and().logout()
				.permitAll();

		httpSecurity.csrf().disable();
		httpSecurity.headers().defaultsDisabled().frameOptions().sameOrigin();
	}

}