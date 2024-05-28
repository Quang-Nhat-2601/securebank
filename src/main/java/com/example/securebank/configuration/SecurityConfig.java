package com.example.securebank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
   @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
       http
               .authorizeHttpRequests(
                       (authorize) -> authorize
                               .requestMatchers("/account", "/myBalance", "/myLoans", "/myCards").authenticated()
                               .requestMatchers("/notices", "/contact").permitAll()
               )
               .httpBasic(Customizer.withDefaults())
               .formLogin(Customizer.withDefaults());
       return http.build();
   }

   @Bean
    public InMemoryUserDetailsManager userDetailsService() {
       UserDetails admin = User.withDefaultPasswordEncoder()
               .username("admin")
               .password("123")
               .authorities("admin")
               .build();
       UserDetails user = User.withDefaultPasswordEncoder()
               .username("user")
               .password("123")
               .authorities("read")
               .build();
       return new InMemoryUserDetailsManager(admin, user);
   }
}