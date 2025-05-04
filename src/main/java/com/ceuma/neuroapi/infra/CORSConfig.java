package com.ceuma.neuroapi.infra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica em todas as rotas
                    .allowedOrigins("*") // Permite qualquer origem
                    .allowedMethods("*") // Permite todos os métodos (GET, POST, etc.)
                    .allowedHeaders("*"); // Permite todos os headers
            }
        };
    }
}