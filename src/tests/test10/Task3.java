package tests.test10;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        String[] testCases = {
                "1, 2, ala , bala",
                "\"hello world\", 1, 2",
                "ala, 2, 'hello world'",
                "ala, 2, 'I\'m fine'",
                "ala, 2, 'c:\\work\\test.log'"
        };

        for (String testCase : testCases) {
            System.out.println("Input: " + testCase);
            String[] result = parseCSV(testCase);
            System.out.print("Output: ");
            for (int i = 0; i < result.length; i++) {
                System.out.print("\"" + result[i] + "\"");
                if (i != result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public static String[] parseCSV(String input) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        boolean inQuotes = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '\"' || c == '\'') {
                inQuotes = !inQuotes;
                if (!inQuotes) {
                    result.add(sb.toString());
                    sb.setLength(0);
                }
            } else if (inQuotes) {
                sb.append(c);
            }
        }

        return result.toArray(new String[0]);
    }
}
