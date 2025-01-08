package io.github.springboot.springarchitecture.automaker;

import java.awt.*;

public class HondaHRV extends Car {

    public HondaHRV(Engine engine) {
        super(engine);
        setModel("HRV");
        setColor(Color.BLACK);
        setAutomaker(Automaker.HONDA);
        
    }
}
