package com.sanmina.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * sprig security 的配置类
 * @author cat
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "login").permitAll()    //设置spring security对/和/login不拦截
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")			//设置spring security的登录界面访问路径为/login
			.defaultSuccessUrl("/chat")				//登录成功后跳转到/chat路径
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("cat").password("cat").roles("USER")  //角色是user
			.and()
			.withUser("nizgg").password("nizgg").roles("USER");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/static/**");
	}
	
}
