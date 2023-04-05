package fileLockingExamples.fileLockingExample2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String text = "Zdravei@abv.bg izprati imeil Zdravei2@abv.bg fdfd Zdravei@.bg";
        System.out.println(extractEmails(text));
    }

    public static List<String> extractEmails (String text) {
        List<String> emails = new ArrayList<>();
        String emailRegex = "([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}
