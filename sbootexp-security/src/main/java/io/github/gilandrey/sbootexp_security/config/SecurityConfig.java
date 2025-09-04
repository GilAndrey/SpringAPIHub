package io.github.gilandrey.sbootexp_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Filter Chain é um filtro que lista e processam cada requisição HTTP que chega na aplicação
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http, SenhaMasterAuthenticationProvider senhaMasterAuthenticationProvider,
            CustomFilter customFilter) throws Exception {
        return http
                .authorizeHttpRequests(customizer -> {
                    customizer.requestMatchers("/public").permitAll(); // Permite que qualquer um acesse /public sem autorização
                    customizer.requestMatchers("/admin").hasRole("ADMIN");
                    customizer.anyRequest().authenticated(); // E todas as outras rotas precise de autorização
                })
                .httpBasic(Customizer.withDefaults()) // Permite a autorização via HTTP basic que é o pop-up do navegador (alert javascript)
                .formLogin(Customizer.withDefaults()) // Habilita a autorização via o Formulario de login.
                .authenticationProvider(senhaMasterAuthenticationProvider)
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // Código para guardar as informações de usuario
    @Bean
    public UserDetailsService userDetailsService() { // Interface fundamental para encontrar informaçoes de usuario
        UserDetails commonUser = User.builder() // Faz a criação de usuarios.
                .username("user")
                .password(passwordEncoder().encode("123")) // Passando password Encoder para codificar a senha
                .roles("USER")
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(commonUser, adminUser);
    }

    // Comando para Criptografar senhas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt é o formato que a senha sera criptografada (recomendado)
    }

    // É uma function Bean, para fazer a configuração do prefixo que o Security pede
    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Passar o prefixo desejado, "comun é ROLE_"
    }
}
