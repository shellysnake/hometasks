package shop.category;

import shop.product.Product;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Category {
    private String name;
    private SortedSet<Product> products = new TreeSet<>();

    public Category() {
    }

    public Category(String name, SortedSet<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedSet<Product> getProducts() {
        return products;
    }

    public void setProducts(SortedSet<Product> products) {
        this.products = products;
    }

    public static void showCategory(Category[] categories) {
        for (Category category : categories) {
            System.out.println("Категория: " + category.getName() + ", товары: ");
            for (Product product : category.getProducts()) {
                System.out.print(product);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }
}
