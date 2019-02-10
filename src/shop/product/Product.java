package shop.product;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Comparable<Product>, Serializable {
    private int id;
    private String name;
    private String catName;
    private double price;
    private int rank;

    public Product(int id, String name, String catName, double price, int rank) {
        this.id = id;
        this.name = name;
        this.catName = catName;
        this.price = price;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Product o) {
        int anotherProductRank = o.getRank();
        int result = this.rank - anotherProductRank;
        if (result != 0) {
            return result;
        } else {
            return (int) (this.price - o.getPrice());
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catName='" + catName + '\'' +
                ", price=" + price +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                rank == product.rank &&
                Objects.equals(name, product.name) &&
                Objects.equals(catName, product.catName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, catName, price, rank);
    }
}
