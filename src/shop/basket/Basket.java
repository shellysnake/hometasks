package shop.basket;

import shop.product.Product;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import static shop.ShopDemo.scanner;
import static shop.category.Category.categories;
import static shop.ShopDemo.user;

public class Basket implements Serializable {
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

    public void addToBasket() {
        System.out.println("Введите название категории выбранного товара");
        if (scanner.hasNextLine()) {
            String catName = scanner.nextLine();
            if (categories.containsKey(catName)) {
                SortedSet<Product> products = categories.get(catName);
                System.out.println("Введите название товара, который вы хотите добавить в корзину");
                if (scanner.hasNextLine()) {
                    String productName = scanner.nextLine();
                    for (Product product : products) {
                        if (product.getName().equals(productName)) {
                            this.products.add(product);
                            System.out.println("Товар успешно добавлен");
                        }
                    }
                }

            }
        }
    }

    public void shopping() {
        this.time = LocalDateTime.now();
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/shop/io/inf_about_purchase.txt")))) {
            pw.printf("User: %s , made a purchase %s. Date - %s", user.getLogin(), user.getBasket(), this.time);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.products.clear();
    }

    public void serialize() {
        try (FileOutputStream fs = new FileOutputStream("src/shop/io/basket_s.ser");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            os.writeObject(user.getBasket());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Basket deserialize() {
        try (FileInputStream fs = new FileInputStream("src/shop/io/basket_s.ser");
             ObjectInputStream os = new ObjectInputStream(fs)) {
            return (Basket) os.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
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
