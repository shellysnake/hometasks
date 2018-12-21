package shop.basket;

import shop.category.Category;
import shop.product.Product;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Basket {
    private List<Product> products;
    private Category[] categories;

    public Basket() {
    }

    public Basket(List<Product> products, Category[] categories) {
        this.products = products;
        this.categories = categories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public void addToBasket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название категории выбранного товара");
        if (scanner.hasNextLine()) {
            String catName = scanner.nextLine();
            for (Category category : categories) {
                if (category.getName().equals(catName)) {
                    System.out.println("Введите название товара, который вы хотите добавить в корзину");
                    if (scanner.hasNextLine()) {
                        String productName = scanner.nextLine();
                        for (Product product : category.getProduct()) {
                            if (product.getName().equals(productName)) {
                                this.products.add(product);
                            }
                        }
                    }
                }
            }
        }
    }

    public void shopping() {
        this.products.removeAll(this.products);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(products, basket.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
