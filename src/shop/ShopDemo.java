package shop;

import shop.actions.Actions;
import shop.category.Category;
import shop.comparators.ProductComparatorName;
import shop.comparators.ProductComparatorPrice;
import shop.product.Product;
import shop.user.User;

import static shop.category.Category.categories;
import static shop.user.User.loginData;

import java.util.*;

public class ShopDemo {
    public static User user = new User();
    private static ProductComparatorPrice productComparatorPrice = new ProductComparatorPrice();
    private static ProductComparatorName productComparatorName = new ProductComparatorName();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initialization();
        menu();
    }

    private static void initialization() {
        SortedSet<Product> products = new TreeSet<>();
        products.add(new Product("Asus", 35573, 5));
        products.add(new Product("Asus VivoBook 15", 15399, 2));
        products.add(new Product("AaDell Inspirion 3552", 6779, 2));

        SortedSet<Product> products1 = new TreeSet<>();
        products1.add(new Product("Lenovo Tab4 plus TB-8704F", 8750, 1));
        products1.add(new Product("aLenovo Tab4-x304L", 5500, 4));
        products1.add(new Product("Nomi C101040 Plus3", 3399, 5));

        categories.put("Laptops", products);
        categories.put("Tablets", products1);
        loginData.put("login1", "qwerty332");
        loginData.put("login2", "password");
    }

    private static void menu() {
        System.out.println("Введите действие: AUTHENTICATION - Регистрация, SHOW_GOODS - Показать товары выбранной категории, " +
                "SHOW_CATALOGS - Показать категории");
        System.out.println("CHOOSE_PRODUCT - Добавить выбранный товар в корзину, SHOPPING - Покупка товаров в корзине");
        if (scanner.hasNextLine()) {
            String act = scanner.nextLine();
            Actions action = Actions.valueOf(act);
            switch (action) {
                case AUTHENTICATION:
                    user.authUser();
                    break;
                case SHOW_GOODS:
                    showGoods();
                    break;
                case SHOW_CATALOGS:
                    Category.showCategory();
                    break;
                case CHOOSE_PRODUCT:
                    addToBasket();
                    System.out.println(user);
                    break;
                case SHOPPING:
                    user.getBasket().shopping();
                    System.out.println(user);
                    break;
                case SORT:
                    Set<Map.Entry<String, SortedSet<Product>>> categorySet = categories.entrySet();
                    for (Map.Entry<String, SortedSet<Product>> category : categorySet) {
                        System.out.printf("Категория - %s \n", category.getKey());
                        System.out.println("По цене");
                        SortedSet<Product> products = new TreeSet<>(productComparatorPrice);
                        products.addAll(category.getValue());
                        for (Product product : products) {
                            System.out.println(product);
                        }
                        System.out.println("По имени");
                        SortedSet<Product> products1 = new TreeSet<>(productComparatorName);
                        products1.addAll(category.getValue());
                        for (Product product : products1) {
                            System.out.println(product);
                        }
                    }
                    break;
                case SERIALIZE:
                    user.getBasket().serialize();
                    break;
                case DESERIALIZE:
                    System.out.println(user.getBasket().deserialize());
                    break;
            }
            System.out.println("Хотите совершить еще одно действие? Y/N");
            if (scanner.hasNextLine()) {
                String act1 = scanner.nextLine();
                if (act1.equals("Y")) {
                    menu();
                }
            }
        }
    }

    private static void addToBasket() {
        user.getBasket().addToBasket();
        System.out.println("Добавить еще один товар в корзину? Y/N");
        if (scanner.hasNextLine()) {
            String act1 = scanner.nextLine();
            if (act1.equals("Y")) {
                addToBasket();
            }
        }
    }

    private static void showGoods() {
        System.out.println("Введите название категории для просмотра товаров:");
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (categories.containsKey(str)) {
                SortedSet<Product> products = categories.get(str);
                for (Product product : products) {
                    System.out.println(product + "; ");
                }
            }
        }
    }
}
