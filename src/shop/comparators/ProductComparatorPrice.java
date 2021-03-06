package shop.comparators;

import shop.product.Product;

import java.util.Comparator;

public class ProductComparatorPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        int result = Double.compare(o2.getPrice(), o1.getPrice());
        if (result != 0) {
            return result;
        } else {
            return o1.getRank() - o2.getRank();
        }
    }
}
