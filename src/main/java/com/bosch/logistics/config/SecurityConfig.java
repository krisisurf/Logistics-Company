package com.bosch.logistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
                // TODO Users without a profile may visit ( /, /status, /deliveryTime, /office, /type )
                .antMatchers("/", "/status", "/deliveryTime", "/office", "/type").authenticated()
                .antMatchers("/api/**", "/customer").hasAnyAuthority("ADMIN", "OFFICE_EMPLOYEE", "DRIVER")
                .antMatchers("/product").hasAnyAuthority("ADMIN", "OFFICE_EMPLOYEE", "DRIVER", "CUSTOMER")
                .antMatchers("/product/**").hasAnyAuthority("ADMIN", "OFFICE_EMPLOYEE")
                .antMatchers("/status/**", "/office/**", "/type/**", "/customer/**").hasAnyAuthority("ADMIN")
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
