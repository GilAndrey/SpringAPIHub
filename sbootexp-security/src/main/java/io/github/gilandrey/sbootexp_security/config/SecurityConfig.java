package io.github.gilandrey.sbootexp_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Filter Chain é um filtro que lista e processam cada requisição HTTP que chega na aplicação
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(customizer -> {
                    customizer.requestMatchers("/public").permitAll(); // Permite que qualquer um acesse /public sem autorização
                    customizer.anyRequest().authenticated(); // E todas as outras rotas precise de autorização
                })
                .httpBasic(Customizer.withDefaults()) // Permite a autorização via HTTP basic que é o pop-up do navegador (alert javascript)
                .formLogin(Customizer.withDefaults()) // Habilita a autorização via o Formulario de login.
                .build();
    }
}
