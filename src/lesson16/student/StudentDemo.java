package lesson16.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Student1", "group1", 3, Arrays.asList(5, 5, 5, 3, 5)));
        students.add(new Student("Student2", "group2", 1, Arrays.asList(2, 1, 2, 3, 3)));
        students.add(new Student("Student3", "group3", 2, Arrays.asList(5, 4, 5, 3, 3)));
        students.add(new Student("Student4", "group1", 3, Arrays.asList(5, 1, 1, 1, 1)));
        students.add(new Student("Student5", "group2", 1, Arrays.asList(5, 1, 1, 3, 2)));
        for (Student student : students) {
            student.isExpelled();
        }
        Student.printStudents(students, 3);
    }
}
