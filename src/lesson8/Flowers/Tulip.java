package lesson8.Flowers;

import java.util.Objects;

public class Tulip extends Flower {
    private double flowerDiameter;

    public Tulip(String producingCountry, int storageTime, double price, double flowerDiameter) {
        super(producingCountry, storageTime, price);
        this.flowerDiameter = flowerDiameter;
    }

    public Tulip() {
    }

    public double getFlowerDiameter() {
        return flowerDiameter;
    }

    public void setFlowerDiameter(double flowerDiameter) {
        this.flowerDiameter = flowerDiameter;
    }

    @Override
    public String toString() {
        return "Tulip{" +
                "flowerDiameter=" + flowerDiameter +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tulip tulip = (Tulip) o;
        return Double.compare(tulip.flowerDiameter, flowerDiameter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flowerDiameter);
    }
}
