package lesson8.students;

public class AspirantsStudentsDemo {
    public static void main(String[] args) {
        Student student3 = new Aspirant("Ivan", "Petrov", "G", 4, "Work");
        Student student1 = new Student("Ivan", "Ivanov", "G1", 5);
        Aspirant aspirant1 = new Aspirant("Petr", "Petrov2", "G2", 4, "Work1");
        Student aspirant2 = new Aspirant("Jenya", "Sidorov", "G3", 5, "Work2");

        Student[] students = {student1, aspirant1, aspirant2, student3};
        for (Student student : students) {
            System.out.println(student.getLastName() + " " + student.getScholarship());
        }
        System.out.println(Student.b);
    }
}
