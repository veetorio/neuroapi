package com.ceuma.neuroapi.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Bean
    public SecurityFilterChain contextOne(HttpSecurity filter) throws Exception{
        filter
            .formLogin(e -> e.disable())
            .csrf(cs -> cs.disable())
            .authorizeHttpRequests(http -> 
                    http.
                        anyRequest().
                        permitAll()
                    );
            return filter.build();
    }

    
} 
