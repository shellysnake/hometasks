package shop;

import shop.actions.Actions;
import shop.basket.Basket;
import shop.category.Category;
import shop.product.Product;
import shop.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product product1 = new Product("Asus", 35573, 1);
        Product product2 = new Product("Asus VivoBook 15", 15399, 2);
        Product product3 = new Product("Dell Inspirion 3552", 6779, 3);
        Product[] products = {product1, product2, product3};
        Category laptops = new Category("Laptops", products);

        Product product4 = new Product("Lenovo Tab4-x304L", 5500, 1);
        Product product5 = new Product("Lenovo Tab4 plus TB-8704F", 8750, 1);
        Product product6 = new Product("Nomi C101040 Plus3", 3399, 3);
        Product[] products1 = {product4, product5, product6};
        Category tablets = new Category("Tablets", products1);

        Category[] categories = {laptops, tablets};
        List<Product> basketList = new ArrayList<>();
        Basket basket = new Basket(basketList, categories);
        User user = new User();
        menu(scanner, categories, basket, user);
    }

    private static void menu(Scanner scanner, Category[] categories, Basket basket, User user) {
        System.out.println("Введите действие: AUTHENTICATION - Регистрация, SHOWGOODS - Показать товары выбранной категории, " +
                "SHOWCATALOGS - Показать категории");
        System.out.println("CHOOSEPRODUCT - Добавить выбранный товар в корзину, SHOPPING - Покупка товаров в корзине");
        if (scanner.hasNextLine()) {
            String act = scanner.nextLine();
            Actions action = Actions.valueOf(act);
            switch (action) {
                case AUTHENTICATION:
                    user.authUser();
                    System.out.println(user);
                    break;
                case SHOWGOODS:
                    showGoods(scanner, categories);
                    break;
                case SHOWCATALOGS:
                    Category.showCategory(categories);
                    break;
                case CHOOSEPRODUCT:
                    basket.addToBasket();
                    System.out.println(basket);
                    break;
                case SHOPPING:
                    basket.shopping();
                    System.out.println(basket);
                    break;
            }
            System.out.println("Хотите совершить еще одно действие? Y/N");
            if (scanner.hasNextLine()) {
                String act1 = scanner.nextLine();
                if (act1.equals("Y")) {
                    menu(scanner, categories, basket, user);
                }
            }
        }
    }

    private static void showGoods(Scanner scanner, Category[] categories) {
        System.out.println("Введите название категории для просмотра товаров:");
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            for (Category category : categories) {
                if (category.getName().equals(str)) {
                    for (Product product : category.getProduct()) {
                        System.out.print(product);
                    }
                }
                System.out.println();
            }
        }
    }
}
