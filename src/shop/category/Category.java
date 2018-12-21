package shop.category;

import shop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class Category {
    private String name;
    private Product[] product;

    public Category() {
    }

    public Category(String name, Product[] product) {
        this.name = name;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public static void showCategory(Category[] categories) {
        for (Category category : categories) {
            System.out.println("Категория: " + category.getName() + ", товары: ");
            for (Product product : category.getProduct()) {
                System.out.print(product);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", product=" + Arrays.toString(product) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Arrays.equals(product, category.product);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(product);
        return result;
    }
}
