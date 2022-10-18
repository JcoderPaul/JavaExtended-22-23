package Less_23_chap_4_LambdaSupplier.MyOwnClasses;

import java.util.Objects;

public class Car {
    private String madel;
    private String color;
    private Double engine_power;

    public Car(String madel, String color, Double engine_power) {
        this.madel = madel;
        this.color = color;
        this.engine_power = engine_power;
    }

    @Override
    public String toString() {
        return "Car: {" +
                "madel= '" + madel + '\'' +
                ", color= '" + color + '\'' +
                ", engine_power= " + engine_power +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(madel, car.madel) &&
               Objects.equals(color, car.color) &&
               Objects.equals(engine_power, car.engine_power);
    }

    @Override
    public int hashCode() {
        return Objects.hash(madel, color, engine_power);
    }

    public String getMadel() {
        return madel;
    }

    public String getColor() {
        return color;
    }

    public Double getEngine_power() {
        return engine_power;
    }

    public void setMadel(String madel) {
        this.madel = madel;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine_power(Double engine_power) {
        this.engine_power = engine_power;
    }
}
