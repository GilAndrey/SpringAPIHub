package io.github.springboot.springarchitecture.automaker;

public class Engine {
    private String model;
    private Integer horsepower;
    private Integer cylinder;
    private Double liter;
    private EngineType type;

    public void engine() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Integer getCylinder() {
        return cylinder;
    }

    public void setCylinder(Integer cylinder) {
        this.cylinder = cylinder;
    }

    public Double getliter() {
        return liter;
    }

    public void setliter(Double liter) {
        this.liter = liter;
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }
}
