package shop.user;

import shop.basket.Basket;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static shop.ShopDemo.scanner;

public class User {
    private String login, password;
    private Basket basket = new Basket();
    public static Map<String, String> loginData = new HashMap<>();

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void authUser() {
        System.out.println("Введите логин: ");
        if (scanner.hasNextLine()) {
            String login = scanner.nextLine();
            System.out.println("Введите пароль и повторите ввод");
            if (scanner.hasNextLine()) {
                String password = scanner.nextLine();
                if (scanner.hasNextLine()) {
                    String confPassword = scanner.nextLine();
                    if (isAuthCorrect(login, password, confPassword) && loginData.containsKey(login) &&
                            (loginData.get(login).equals(password))) {
                        this.login = login;
                        this.password = password;
                        System.out.println("User authenticated");
                    }
                }
            }
        }
    }

    public static boolean isAuthCorrect(String login, String password, String confirmPassword) {
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
        } finally {
            System.out.printf("Login %s, password %s, confPassword %s \n", login, password, confirmPassword);
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", basket=" + basket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(basket, user.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, basket);
    }
}
