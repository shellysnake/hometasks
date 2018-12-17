package lesson8.com.company.vehicles;

import lesson8.com.company.details.Engine;
import lesson8.com.company.professions.Driver;

import java.util.Objects;

public class SportCar extends Car {
    private double speed;

    public SportCar(String carModel, String carClass, double carWeight, Driver driver, Engine engine, double speed) {
        super(carModel, carClass, carWeight, driver, engine);
        this.speed = speed;
    }

    public SportCar() {
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "speed=" + speed +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportCar sportCar = (SportCar) o;
        return Double.compare(sportCar.speed, speed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed);
    }
}
