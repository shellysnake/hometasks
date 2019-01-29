package lesson12;

public class StringsDemo {
    public static void stringDemo(String s) {
        System.out.printf("Последний символ строки - %s\n", s.charAt(s.length() - 1));
        System.out.println(s.endsWith("!!!"));
        System.out.println(s.startsWith("I like"));
        System.out.println(s.indexOf("Java"));
        System.out.println(s.replace("a", "o"));
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.substring(7, 11));
    }

    public static void stringBuilderDemo(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println(stringBuilder);
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(a).append(" - ").append(b).append(" = ").append(a - b);
        System.out.println(stringBuilder);
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(a).append(" * ").append(b).append(" = ").append(a * b);
        System.out.println(stringBuilder);

    }

    public static void main(String[] args) {
        stringDemo("I like Java!!!");
        stringBuilderDemo(3, 56);
    }
}
