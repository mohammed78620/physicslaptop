package com.example.physicslaptop.config;

import com.example.physicslaptop.service.PhysicsUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    private PhysicsUserDetails physicsUserDetails;

    @Autowired
    public SecurityConfig(PhysicsUserDetails physicsUserDetails,DataSource dataSource){
        this.physicsUserDetails = physicsUserDetails;
        this.dataSource = dataSource;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email, password, 'TRUE' as enabled FROM USER WHERE email=?")
                .authoritiesByUsernameQuery("SELECT email, 'ROLE_USER' as authority FROM USER WHERE email=?")
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/register")
                .permitAll()
                .antMatchers("/users","/profile")
                .authenticated()
                .and()
                .formLogin();



        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(physicsUserDetails);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }


}
