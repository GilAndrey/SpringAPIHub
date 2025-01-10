package io.github.springboot.springarchitecture.automaker.configuration;

import io.github.springboot.springarchitecture.automaker.Engine;
import io.github.springboot.springarchitecture.automaker.EngineType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AutomakerConfiguration {

    @Primary
    @Bean(name = "aspiratedEngine")
    public Engine aspiratedEngine() {
        var engine = new Engine();
        engine.setHorsepower(120);
        engine.setCylinder(4);
        engine.setModel("XPTO-0");
        engine.setliter(2.0);
        engine.setType(EngineType.ASPIRATED);
        return engine;
    }

    @Bean(name = "electricEngine")
    public Engine electricEngine() {
        var engine = new Engine();
        engine.setHorsepower(110);
        engine.setCylinder(3);
        engine.setModel("TH-10");
        engine.setliter(1.4);
        engine.setType(EngineType.ELECTRIC);
        return engine;
    }

    @Bean(name = "turboEngine")
    public Engine turboEngine() {
        var engine = new Engine();
        engine.setHorsepower(180);
        engine.setCylinder(4);
        engine.setModel("XPTO-01");
        engine.setliter(1.5);
        engine.setType(EngineType.TURBO);
        return engine;
    }

}
