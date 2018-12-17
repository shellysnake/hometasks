package lesson8.com.company.details;

import java.util.Objects;

public class Engine {
    private int capacity;
    private String manufacturer;

    public Engine(int capacity, String manufacturer) {
        this.capacity = capacity;
        this.manufacturer = manufacturer;
    }

    public Engine() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "capacity=" + capacity +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return capacity == engine.capacity &&
                Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, manufacturer);
    }
}
