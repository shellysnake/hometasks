package shop.basket;

import shop.category.Category;
import shop.product.Product;

import java.time.LocalDateTime;
import java.util.*;

public class Basket {
    private List<Product> products = new ArrayList<>();
    private LocalDateTime time;

    public Basket() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addToBasket(Category[] categories) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название категории выбранного товара");
        if (scanner.hasNextLine()) {
            String catName = scanner.nextLine();
            for (Category category : categories) {
                if (category.getName().equals(catName)) {
                    System.out.println("Введите название товара, который вы хотите добавить в корзину");
                    if (scanner.hasNextLine()) {
                        String productName = scanner.nextLine();
                        for (Product product : category.getProducts()) {
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
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int dayYear = now.getDayOfYear();
        int hour = now.getHour();
        int minute = now.getMinute();
        this.time = LocalDateTime.of(year, month, dayYear, hour, minute);
        this.products.clear();
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
