package io.github.springboot.springarchitecture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExempleValue {

    @Value("${app.config.variavel}")
    private String variavel;

    public void imprimirVariavel() {
        System.out.println(variavel);
    }
}
