package tests.test9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        String text = """
                      ala
                      bala
                      portokala
                      """;
        for (String line : splitLines(text)) {
            System.out.println(line);
        }

        String text2 = "";
        for (String line : splitLines(text2)) {
            System.out.println(line);
        }
    }

    public static List<String> splitLines(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.singletonList("Text cannot be null or empty.");
        }

        List<String> lines = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                lines.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) {
            lines.add(text.substring(start));
        }
        return lines;
    }
}
