package io.github.springboot.libraryapi.config;

import io.github.springboot.libraryapi.security.CustomUserDetailsService;
import io.github.springboot.libraryapi.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Annotations para colocar em classe que é do tipo segurança
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults()) //  ->  Recebe autenticação via Postman ou outra aplicação -> Utiliza-se em basic 64, "Não muito segura"
//                .formLogin(configurer -> {
//                    configurer.loginPage("/login").permitAll(); // -> Recebe autenticação via formulario de Login (Caso use o Browser) -> apontando para a pagina de login
//                })
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> {

//                    authorize.requestMatchers("/login").permitAll();
//                    authorize.requestMatchers(HttpMethod.POST,"/autores/**").hasAuthority("CADASTRAR_AUTOR"); // -> Colocando o Metodo de POST no HttpMethod.POST
//                    authorize.requestMatchers(HttpMethod.DELETE,"/autores/**").hasRole("ADMIN"); // -> Colocando o Metodo de DELETE no HttpMethod.
//                    authorize.requestMatchers(HttpMethod.PUT,"/autores/**").hasRole("ADMIN"); // -> Colocando o Metodo de PUT
//                    authorize.requestMatchers(HttpMethod.GET,"/autores/**").hasAnyRole("ADMIN", "USER");


                    authorize.requestMatchers("/login/**").permitAll();
                    authorize.requestMatchers(HttpMethod.POST, "/usuarios/**").permitAll();


                    authorize.anyRequest().authenticated(); // -> Qualquer requisição feita para a API, tem que esta autenticada
                })
                .oauth2Login(Customizer.withDefaults())
                .build();
    }

    // Metodos de mais segurança com senhas para passar dentro do UserDetailsService
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Ele compara o número com a senha passada para ver se é compativel -> o número é a quantidade de vezes que ele irar passar em cima do password
        return new BCryptPasswordEncoder(10);
    }

    // Metodo para criar os cargos dentro de uma webSite
    //@Bean
    public UserDetailsService userDetailsService(UsuarioService usuarioService) {
//        UserDetails user1 = User.builder()
//                .username("usuario")
//                .password(encoder.encode("123"))
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("admin")
//                .password(encoder.encode("321"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);

        return new CustomUserDetailsService(usuarioService);
    }

    // Remove o prefixo que o SpringBoot passa antes das roles definidas. "ROLE_"
    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }
}
