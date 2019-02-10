package shop.product;

import shop.db.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProductDAO {
    public static final String SQL_SELECT_ALL_PRODUCTS = "SELECT * FROM products;";

    public SortedSet<Product> findAll() {
        SortedSet<Product> products = new TreeSet<>();
        try (Connection connection = DBConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PRODUCTS);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String catName = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                int rank = resultSet.getInt(5);
                products.add(new Product(id, name, catName, price, rank));
            }
        } catch (SQLException e) {
            System.out.println("SQL exception: table or request failed " + e.getMessage());
        }
        return products;
    }
}
