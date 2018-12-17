package lesson8.flowers;

import java.util.Objects;

public class Flower {
    private String producingCountry;
    private int storageTime;
    private double price;
    static int k;

    public Flower(String producingCountry, int storageTime, double price) {
        this.producingCountry = producingCountry;
        this.storageTime = storageTime;
        this.price = price;
        k++;
    }

    public Flower() {
        k++;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public int getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(int storageTime) {
        this.storageTime = storageTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "producingCountry='" + producingCountry + '\'' +
                ", storageTime=" + storageTime +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return storageTime == flower.storageTime &&
                Double.compare(flower.price, price) == 0 &&
                Objects.equals(producingCountry, flower.producingCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producingCountry, storageTime, price);
    }
}
