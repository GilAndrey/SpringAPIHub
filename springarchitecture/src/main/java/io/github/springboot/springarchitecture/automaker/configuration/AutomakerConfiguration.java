package io.github.springboot.springarchitecture.automaker.configuration;

import io.github.springboot.springarchitecture.automaker.Engine;
import io.github.springboot.springarchitecture.automaker.EngineType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutomakerConfiguration {

    @Bean
    public Engine engine() {
        var engine = new Engine();
        engine.setHorsepower(120);
        engine.setCylinder(4);
        engine.setModel("XPTO-0");
        engine.setliter(2.0);
        engine.setType(EngineType.ASPIRATED);
        return engine;
    }

}
