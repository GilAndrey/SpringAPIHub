package io.github.springboot.springarchitecture.automaker.api;

import io.github.springboot.springarchitecture.automaker.Engine;
import io.github.springboot.springarchitecture.automaker.HondaHRV;
import io.github.springboot.springarchitecture.automaker.Key;
import io.github.springboot.springarchitecture.automaker.StatusCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class testFactoryController {

    @Autowired
    @Electric
    private Engine engine;

    @PostMapping
    public StatusCar startCar(@RequestBody Key key) {
        var car = new HondaHRV(engine);
        return car.ignite(key);
    }
}
