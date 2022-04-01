package com.example.exam.config;

import com.example.exam.service.MyUserDatailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDatailsService myUserDatailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDatailsService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/goodGroup/**").hasAnyRole("ADMIN", "OWNER", "USER")
                .antMatchers(HttpMethod.POST, "/goodGroup/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/goodGroup").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/goodGroup/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/good/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/good").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/good/**").hasAnyRole("ADMIN")
                .antMatchers("/sales/**").hasAnyRole("ADMIN", "OWNER", "USER")
                .antMatchers("/users/**").hasRole("OWNER")
                .antMatchers("/roles/**").hasRole("OWNER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
