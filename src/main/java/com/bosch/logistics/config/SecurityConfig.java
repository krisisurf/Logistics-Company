package com.bosch.logistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/api/address", "/api/customer", "/customer", "/product").hasAnyAuthority("ADMIN", "OFFICE_EMPLOYEE", "DRIVER")
                .antMatchers("/customer/create-customer", "/customer/create", "/customer/edit", "/customer/update", "/customer/delete",
                        "/status/create-status", "/status/create", "/status/edit", "/status/update", "/status/delete").hasAnyAuthority("ADMIN")
                .antMatchers("/status", "/deliveryTime", "/office", "/type").hasAnyAuthority("CUSTOMER", "ADMIN", "OFFICE_EMPLOYEE")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .permitAll();
    }

}
