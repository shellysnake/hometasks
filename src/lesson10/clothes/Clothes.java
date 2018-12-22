package lesson10.clothes;

import java.util.Objects;

public abstract class Clothes {
    private int size;
    private double price;
    private String color;

    public Clothes(int size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Clothes() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "size=" + size +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return size == clothes.size &&
                Double.compare(clothes.price, price) == 0 &&
                Objects.equals(color, clothes.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, price, color);
    }
}
