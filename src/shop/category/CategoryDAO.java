package shop.category;

import shop.db.DBConnector;
import shop.product.Product;

import java.sql.*;
import java.util.*;

public class CategoryDAO {
    public static final String GET_CATEGORIES = "SELECT * FROM category;";
    public static final String GET_PRODUCTS = "SELECT * FROM products WHERE category_name=?;";

    public Map<String, SortedSet<Product>> getCategories() {
        Map<String, SortedSet<Product>> categories = new HashMap<>();
        List<String> categoryNames = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement ps = connection.prepareStatement(GET_PRODUCTS);) {
            ResultSet rs = statement.executeQuery(GET_CATEGORIES);
            while (rs.next()) {
                String catName = rs.getString(1);
                categoryNames.add(catName);
            }
            for (String name : categoryNames) {
                SortedSet<Product> products = new TreeSet<>();
                ps.setString(1, name);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String productName = resultSet.getString(2);
                    String catName = resultSet.getString(3);
                    double price = resultSet.getDouble(4);
                    int rank = resultSet.getInt(5);
                    products.add(new Product(id, productName, catName, price, rank));
                }
                categories.put(name, products);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
}
