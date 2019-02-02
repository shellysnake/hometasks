package lesson18.task5;

import java.io.File;
import java.util.Scanner;

public class DirectoryInf {
    public static void main(String[] args) {
        System.out.println("Введите путь к каталогу");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            infAboutDirectory(str);
        }
    }

    public static void infAboutDirectory(String s) {
        File file = new File(s);
        if (file.isDirectory()) {
            System.out.println("Папка " + s);
            String[] list = file.list();
            if (list != null) {
                for (String name : list) {
                    infAboutDirectory(s + "\\" + name);
                }
            }
        } else {
            System.out.println("Файл " + s);
        }
    }
}
