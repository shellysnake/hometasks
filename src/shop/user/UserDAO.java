package shop.user;

import shop.db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static final String ADD_NEW_USER = "INSERT INTO users(user_login,user_password) VALUES (?,?);";
    public static final String SEARCH_USER = "SELECT * FROM users WHERE user_login=? AND user_password=?;";

    public void addNewUser(String login, String password) {
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement ps = connection.prepareStatement(ADD_NEW_USER)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ps.execute();
            System.out.println("User added");
        } catch (SQLException e) {
            System.out.println("Exception failed " + e.getMessage());
        }
    }

    public User authUser(String login, String password) {
        User user = null;
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement ps = connection.prepareStatement(SEARCH_USER)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String userLogin = rs.getString(2);
                String userPassword = rs.getString(3);
                user = new User(id, userLogin, userPassword);
                System.out.printf("User - %s authenticated\n", user);
            }
        } catch (SQLException e) {
            System.out.println("Exception failed " + e.getMessage());
        }
        return user;
    }
}
