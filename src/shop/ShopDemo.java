package shop;

import shop.actions.Actions;
import shop.category.Category;
import shop.comparators.ProductComparatorName;
import shop.comparators.ProductComparatorPrice;
import shop.product.Product;
import shop.user.User;

import java.net.SocketException;
import java.util.*;

public class ShopDemo {
    public static User user = new User();

    public static void main(String[] args) {
        ProductComparatorPrice productComparatorPrice = new ProductComparatorPrice();
        ProductComparatorName productComparatorName = new ProductComparatorName();
        Scanner scanner = new Scanner(System.in);

        SortedSet<Product> products = new TreeSet<>();
        products.add(new Product("Asus", 35573, 5));
        products.add(new Product("Asus VivoBook 15", 15399, 2));
        products.add(new Product("AaDell Inspirion 3552", 6779, 2));
        Category laptops = new Category("Laptops", products);

        SortedSet<Product> products1 = new TreeSet<>();
        products1.add(new Product("Lenovo Tab4-x304L", 5500, 4));
        products1.add(new Product("Lenovo Tab4 plus TB-8704F", 8750, 1));
        products1.add(new Product("Nomi C101040 Plus3", 3399, 5));
        Category tablets = new Category("Tablets", products1);

        Category[] categories = {laptops, tablets};
        Map<String, String> loginData = new HashMap<>();
        loginData.put("login", "qwerty");
        loginData.put("login1", "password");

        menu(scanner, categories, loginData, productComparatorPrice, productComparatorName);
    }

    private static void menu(Scanner scanner, Category[] categories, Map<String, String> map, ProductComparatorPrice productComparatorPrice, ProductComparatorName productComparatorName) {
        System.out.println("Введите действие: AUTHENTICATION - Регистрация, SHOWGOODS - Показать товары выбранной категории, " +
                "SHOWCATALOGS - Показать категории");
        System.out.println("CHOOSEPRODUCT - Добавить выбранный товар в корзину, SHOPPING - Покупка товаров в корзине");
        if (scanner.hasNextLine()) {
            String act = scanner.nextLine();
            Actions action = Actions.valueOf(act);
            switch (action) {
                case AUTHENTICATION:
                    user.authUser();
                    if (map.containsKey(user.getLogin()) && (map.get(user.getLogin()).equals(user.getPassword()))) {
                        System.out.println("User authenticated");
                    }
                    break;
                case SHOWGOODS:
                    showGoods(scanner, categories);
                    break;
                case SHOWCATALOGS:
                    Category.showCategory(categories);
                    break;
                case CHOOSEPRODUCT:
                    addToBasket(scanner, categories, user);
                    System.out.println(user);
                    break;
                case SHOPPING:
                    user.getBasket().shopping();
                    System.out.println(user);
                    break;
                case SORT:
                    for (Category category : categories) {
                        System.out.printf("Категория - %s\n", category.getName());
                        System.out.println("По цене");
                        SortedSet<Product> products = new TreeSet<>(productComparatorPrice);
                        products.addAll(category.getProducts());
                        for (Product product : products) {
                            System.out.println(product);
                        }
                        System.out.println("По имени");
                        SortedSet<Product> products1 = new TreeSet<>(productComparatorName);
                        products1.addAll(category.getProducts());
                        for (Product product : products1) {
                            System.out.println(product);
                        }

                    }
                    break;
            }
            System.out.println("Хотите совершить еще одно действие? Y/N");
            if (scanner.hasNextLine()) {
                String act1 = scanner.nextLine();
                if (act1.equals("Y")) {
                    menu(scanner, categories, map, productComparatorPrice, productComparatorName);
                }
            }
        }
    }

    private static void addToBasket(Scanner scanner, Category[] categories, User user) {
        user.getBasket().addToBasket(categories);
        System.out.println("Добавить еще один товар в корзину? Y/N");
        if (scanner.hasNextLine()) {
            String act1 = scanner.nextLine();
            if (act1.equals("Y")) {
                addToBasket(scanner, categories, user);
            }
        }
    }

    private static void showGoods(Scanner scanner, Category[] categories) {
        System.out.println("Введите название категории для просмотра товаров:");
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            for (Category category : categories) {
                if (category.getName().equals(str)) {
                    for (Product product : category.getProducts()) {
                        System.out.print(product);
                    }
                }
                System.out.println();
            }
        }
    }
}
