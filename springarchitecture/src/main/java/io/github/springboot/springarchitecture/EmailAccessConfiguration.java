package io.github.springboot.springarchitecture;

import io.github.springboot.springarchitecture.todos.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailAccessConfiguration {

    @Autowired
    private AppProperties properties;

    // @Bean
    public MailSender mailSender() {
        return null;
    }

}
