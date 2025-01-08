package io.github.springboot.springarchitecture.automaker;

import java.awt.*;

public class Car {

    private String model;
    private Color color;
    private Engine engine;
    private Automaker automaker;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Automaker getAutomaker() {
        return automaker;
    }

    public void setAutomaker(Automaker automaker) {
        this.automaker = automaker;
    }

    public StatusCar ignite(Key key) {
        if (key.getAutomaker() != this.automaker) {
            return new StatusCar("Don't is possible start car with this key!");
        }
        return new StatusCar("Car running. Running with engine " + engine);
    }
}
