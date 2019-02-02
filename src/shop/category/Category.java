package shop.category;

import shop.product.Product;

import java.util.*;

public class Category {
    public static HashMap<String, SortedSet<Product>> categories = new HashMap<>();

    public static void showCategory() {
        Set<Map.Entry<String, SortedSet<Product>>> categorySet = categories.entrySet();
        for (Map.Entry<String, SortedSet<Product>> category : categorySet) {
            System.out.printf("Категория - %s \n", category.getKey());
            SortedSet<Product> products = new TreeSet<>();
            products.addAll(category.getValue());
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
