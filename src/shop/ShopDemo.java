package shop;

import shop.actions.Actions;
import shop.category.CategoryDAO;
import shop.comparators.ProductComparatorName;
import shop.comparators.ProductComparatorPrice;
import shop.product.Product;
import shop.product.ProductDAO;
import shop.user.User;
import shop.user.UserDAO;

import java.util.*;

public class ShopDemo {
    private static ProductComparatorPrice productComparatorPrice = new ProductComparatorPrice();
    private static ProductComparatorName productComparatorName = new ProductComparatorName();
    public static User user = new User();
    public static ProductDAO productDAO = new ProductDAO();
    public static UserDAO userDAO = new UserDAO();
    public static CategoryDAO categoryDAO = new CategoryDAO();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        System.out.println("Введите действие: REGISTRATION, AUTHENTICATION, SHOW_GOODS, SHOW_CATALOGS, " +
                "CHOOSE_PRODUCT, SHOPPING, SORT, SERIALIZE, DESERIALIZE");
        if (scanner.hasNextLine()) {
            String act = scanner.nextLine();
            Actions action = Actions.valueOf(act);
            switch (action) {
                case REGISTRATION:
                    userDAO.addNewUser();
                    break;
                case AUTHENTICATION:
                    user = userDAO.authUser();
                    break;
                case SHOW_GOODS:
                    showGoods();
                    break;
                case SHOW_CATALOGS:
                    showCategory();
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
                    sortGoods();
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

    private static void sortGoods() {
        Set<Map.Entry<String, SortedSet<Product>>> categorySet = categoryDAO.getCategories().entrySet();
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
        SortedSet<Product> products = productDAO.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void showCategory() {
        Set<Map.Entry<String, SortedSet<Product>>> categorySet = categoryDAO.getCategories().entrySet();
        for (Map.Entry<String, SortedSet<Product>> category : categorySet) {
            System.out.printf("Категория - %s \n", category.getKey());
            System.out.println("Товары ");
            for (Product product : category.getValue()) {
                System.out.println(product);
            }
        }
    }
}
