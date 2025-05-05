package io.github.springboot.libraryapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

// Annotations para colocar em classe que é do tipo segurança
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults()) //  ->  Recebe autenticação via Postman ou outra aplicação -> Utiliza-se em basic 64, "Não muito segura"
                .formLogin(configurer -> {
                    configurer.loginPage("/login").permitAll(); // -> Recebe autenticação via formulario de Login (Caso use o Browser) -> apontando para a pagina de login
                })


                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().authenticated(); // -> Qualquer requisição feita para a API, tem que esta autenticada
                })
                .build();
    }

}
