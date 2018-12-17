package lesson8.flowers;

import java.util.Objects;

public class Rose extends Flower {
    private String color;

    public Rose(String producingCountry, int storageTime, double price, String color) {
        super(producingCountry, storageTime, price);
        this.color = color;
    }

    public Rose() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rose{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rose rose = (Rose) o;
        return Objects.equals(color, rose.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
