package Less_23_chap_6_LambdaFunction.MyOwnClasses;

import java.util.Objects;

public class Car {
    private String madel;
    private String color;
    private Double engine_power;
    private int door_count;
    private int piston_count;

    public Car(String madel, String color, Double engine_power, int door_count, int piston_count) {
        this.madel = madel;
        this.color = color;
        this.engine_power = engine_power;
        this.door_count = door_count;
        this.piston_count = piston_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return door_count == car.door_count &&
               piston_count == car.piston_count &&
               Objects.equals(madel, car.madel) &&
               Objects.equals(color, car.color) &&
               Objects.equals(engine_power, car.engine_power);
    }

    @Override
    public int hashCode() {
        return Objects.hash(madel, color, engine_power, door_count, piston_count);
    }

    @Override
    public String toString() {
        return "Car: {" +
                "madel= '" + madel + '\'' +
                ", color= '" + color + '\'' +
                ", engine_power= " + engine_power +
                ", door_count= " + door_count +
                ", piston_count= " + piston_count +
                '}';
    }

    public String getMadel() {
        return madel;
    }

    public void setMadel(String madel) {
        this.madel = madel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getEngine_power() {
        return engine_power;
    }

    public void setEngine_power(Double engine_power) {
        this.engine_power = engine_power;
    }

    public int getDoor_count() {
        return door_count;
    }

    public void setDoor_count(int door_count) {
        this.door_count = door_count;
    }

    public int getPiston_count() {
        return piston_count;
    }

    public void setPiston_count(int piston_count) {
        this.piston_count = piston_count;
    }
}
