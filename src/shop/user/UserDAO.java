package shop.user;

import shop.db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static shop.ShopDemo.scanner;

public class UserDAO {
    public static final String ADD_NEW_USER = "INSERT INTO users(user_login,user_password) VALUES (?,?);";
    public static final String SEARCH_USER = "SELECT * FROM users WHERE user_login=? AND user_password=?;";

    public void addNewUser() {
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement ps = connection.prepareStatement(ADD_NEW_USER)) {
            System.out.println("Введите логин: ");
            if (scanner.hasNextLine()) {
                String login = scanner.nextLine();
                System.out.println("Введите пароль и повторите ввод");
                if (scanner.hasNextLine()) {
                    String password = scanner.nextLine();
                    if (scanner.hasNextLine()) {
                        String confPassword = scanner.nextLine();
                        if (isDataCorrect(login, password, confPassword)) {
                            ps.setString(1, login);
                            ps.setString(2, password);
                            ps.execute();
                            System.out.println("User added");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception failed " + e.getMessage());
        }
    }

    public User authUser() {
        User user = null;
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement ps = connection.prepareStatement(SEARCH_USER)) {
            System.out.println("Введите логин: ");
            if (scanner.hasNextLine()) {
                String login = scanner.nextLine();
                System.out.println("Введите пароль");
                if (scanner.hasNextLine()) {
                    String password = scanner.nextLine();
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
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception failed " + e.getMessage());
        }
        return user;
    }

    public static boolean isDataCorrect(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("^[a-zA-Z0-9_-]{5,19}$")) {
                throw new WrongLoginException("Login > 20");
            }
            if (!password.matches("^[a-zA-Z0-9_-]{5,19}$") || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password>20 or Password != confirmPassword");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
