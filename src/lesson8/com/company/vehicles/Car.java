package lesson8.com.company.vehicles;

import lesson8.com.company.details.Engine;
import lesson8.com.company.professions.Driver;

import java.util.Objects;

public class Car {
    private String carModel, carClass;
    private double carWeight;
    private Driver driver;
    private Engine engine;

    public Car(String carModel, String carClass, double carWeight, Driver driver, Engine engine) {
        this.carModel = carModel;
        this.carClass = carClass;
        this.carWeight = carWeight;
        this.driver = driver;
        this.engine = engine;
    }

    public Car() {
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public double getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(double carWeight) {
        this.carWeight = carWeight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        System.out.println("Поехали " + this.carModel);
    }

    public void stop() {
        System.out.println("Останавливаемся " + this.carModel);
    }

    public void turnRight() {
        System.out.println("Поворот направо " + this.carModel);
    }

    public void turnLeft() {
        System.out.println("Поворот налево " + this.carModel);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", carClass='" + carClass + '\'' +
                ", carWeight=" + carWeight +
                ", driver=" + driver +
                ", engine=" + engine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.carWeight, carWeight) == 0 &&
                Objects.equals(carModel, car.carModel) &&
                Objects.equals(carClass, car.carClass) &&
                Objects.equals(driver, car.driver) &&
                Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carModel, carClass, carWeight, driver, engine);
    }
}
