package lesson9.fruits;

import java.util.Objects;

public abstract class Fruit {
    private double weight;
    public static double costOfFruits;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public Fruit() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract double getFruitPrice();

    public void printManufacturerInfo() {
        System.out.println("Made in Ukraine");
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
