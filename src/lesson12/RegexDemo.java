package lesson12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String stringPattern = "^[a-zA-Z0-9_-]{5,20}$";
        String text = "LOgIn123_5";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
        if (text.matches("^[a-z0-9_-]{5,20}$")){
            System.out.println(text);
        }
    }
}
