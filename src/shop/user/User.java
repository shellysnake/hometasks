package shop.user;

import shop.basket.Basket;

import java.util.Objects;
import java.util.Scanner;

public class User {
    private String login, password;
    private Basket basket = new Basket();

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        if (scanner.hasNextLine()) {
            this.setLogin(scanner.nextLine());
            System.out.println("Введите пароль: ");
            if (scanner.hasNextLine()) {
                this.setPassword(scanner.nextLine());
            }
        }
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
