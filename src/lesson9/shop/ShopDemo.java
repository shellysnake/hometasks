package lesson9.shop;

import lesson9.shop.basket.Basket;
import lesson9.shop.category.Category;
import lesson9.shop.product.Product;
import lesson9.shop.user.User;

import java.util.Base64;

public class ShopDemo {
    public static void main(String[] args) {
        Product product1 = new Product("Asus ZenBook 13", 35573, 1);
        Product product2 = new Product("Asus VivoBook 15", 15399, 2);
        Product product3 = new Product("Dell Inspirion 3552", 6779, 3);
        Product[] products = {product1, product2, product3};
        Category category = new Category("Laptops", products);
        Product product4 = new Product("Lenovo Tab4-x304L", 5500, 1);
        Product product5 = new Product("Lenovo Tab4 plus TB-8704F", 8750, 1);
        Product product6 = new Product("Nomi C101040 Plus3", 3399, 3);
        Product[] products1 = {product4, product5, product6};
        Category category1 = new Category("Tablets", products1);
        Product[] products2 = {product1, product4};
        Basket basket = new Basket(products2);
        User user = new User("login", "password", basket);
    }
}
