package com.ceuma.neuroapi.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    private final UserDetailsUsuarios userDetailsUsuarios;

    public SpringSecurity(UserDetailsUsuarios userDetailsUsuarios) {
        this.userDetailsUsuarios = userDetailsUsuarios; // Injeção correta do serviço
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Usando BCrypt para codificação de senha
    }

    @Order(1)
    @Bean
    public SecurityFilterChain contextOne(HttpSecurity filter) throws Exception {
        filter
                .authorizeHttpRequests(http -> http
                        .anyRequest()
                        .permitAll())
                .formLogin(e -> e.disable())
                .csrf(cs -> cs.disable())
                .cors(e -> e.disable())
                .userDetailsService(userDetailsUsuarios);
        // .csrf(cs -> cs.disable())
        // .authorizeHttpRequests(http ->
        // http
        // .requestMatchers("/mr")
        // .hasRole("MEDICO")
        // .requestMatchers("/usuarios", "/instituicoes")
        // .hasRole("RESIDENTE")
        // .anyRequest()
        // .permitAll()
        // )
        // .userDetailsService(userDetailsUsuarios)
        // .httpBasic();
        return filter.build();
    }

}
