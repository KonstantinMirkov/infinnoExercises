package tests.test4;

public class Task3 {
    public static void main(String[] args) {
        String str1 = "abc133d";
        System.out.println(trimString(str1));

        String str2 = "123456789";
        System.out.println(trimString(str2));

        String str3 = "alabala";
        System.out.println(trimString(str3));

        String str4 = "";
        System.out.println(trimString(str4));
    }

    public static String trimString(String input) {
        if (input == null || input.isEmpty()) {
            return "No string provided.";
        }

        StringBuilder letterResult = new StringBuilder();
        StringBuilder numberResult = new StringBuilder();
        StringBuilder finalResult = new StringBuilder();

        int i = 0;
        while (i < input.length()) {
            if (Character.isLetter(input.charAt(i))) {
                letterResult.append(input.charAt(i));
            } else {
                numberResult.append(input.charAt(i));
            }
            i++;
        }

        if (letterResult.length() == 0 && numberResult.length() == 0) {
            return "";
        }

        if (Math.abs(letterResult.length() - numberResult.length()) > 1) {
            return "";
        }

        int j = 0;
        int k = 0;
        boolean isLetterNext = letterResult.length() > numberResult.length();
        while (j < letterResult.length() || k < numberResult.length()) {
            if (isLetterNext && j < letterResult.length()) {
                finalResult.append(letterResult.charAt(j));
                j++;
                isLetterNext = false;
            } else if (!isLetterNext && k < numberResult.length()) {
                finalResult.append(numberResult.charAt(k));
                k++;
                isLetterNext = true;
            }
        }

        return finalResult.toString();
    }
}
