package lesson8.com.company;

import lesson8.com.company.details.Engine;
import lesson8.com.company.professions.Driver;
import lesson8.com.company.professions.Person;
import lesson8.com.company.vehicles.Car;
import lesson8.com.company.vehicles.Lorry;
import lesson8.com.company.vehicles.SportCar;

public class CarDemo {
    public static void main(String[] args) {
        Engine engine1 = new Engine(1000, "company1");
        Engine engine2 = new Engine(2000, "company2");
        Driver driver1 = new Driver(20, "Ivan Ivanov", 2);
        Driver driver2 = new Driver(30, "Ivan Petrov", 10);
        Car lorry1 = new Lorry("lorry", "class1", 2000.0, driver1, engine1, 500);
        SportCar sportCar1 = new SportCar("sportCar", "class2", 1500, driver2, engine2, 200.0);

        lorry1.start();
        lorry1.stop();
        lorry1.toString();

        sportCar1.start();
        sportCar1.turnLeft();
        sportCar1.turnRight();
        sportCar1.stop();
        sportCar1.toString();
    }
}
