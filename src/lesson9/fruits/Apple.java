package lesson9.fruits;

import java.util.Objects;

public class Apple extends Fruit {
    private double price;
    public static double costOfApples;

    public Apple(double weight, double price) {
        super(weight);
        this.price = price;
        costOfFruits += price * weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getFruitPrice() {
        return price * getWeight();
    }

    @Override
    public String toString() {
        return "Apple{" +
                "price=" + price +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return Double.compare(apple.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}
