package com.group.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authz -> authz
//                .requestMatchers("/ui/**").permitAll()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                .anyRequest().authenticated()
                                .requestMatchers("/api/**").authenticated()
                                .requestMatchers("/book/**").authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/")
                        .loginProcessingUrl("/loginProcess")
                        .defaultSuccessUrl("/")
                        .failureUrl("/?error=true")
                        .permitAll()
                )
                .logout(logout->logout
                        .logoutUrl("/logout") //
                        .logoutSuccessUrl("/?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .build();
    }

}
