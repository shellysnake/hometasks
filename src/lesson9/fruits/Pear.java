package lesson9.fruits;

import java.util.Objects;

public class Pear extends Fruit {
    private double price;
    public static double costOfPears;

    public Pear(double weight, double price) {
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
        return "Pear{" +
                "price=" + price +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pear pear = (Pear) o;
        return Double.compare(pear.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}
