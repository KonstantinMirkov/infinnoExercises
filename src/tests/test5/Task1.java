package tests.test5;

import java.util.Stack;

public class Task1 {
    public static void main(String[] args) {
        String str1 = "()";
        System.out.println(isValid(str1)); // true

        String str2 = "()[]{}";
        System.out.println(isValid(str2)); // true

        String str3 = "(]";
        System.out.println(isValid(str3)); // false

        String str4 = "([)]";
        System.out.println(isValid(str4)); // false

        String str5 = "{[]}";
        System.out.println(isValid(str5)); // true

        String str6 = "";
        String str7 = null;
        System.out.println(isValid(str6) + " " + isValid(str7)); // false false
    }

    public static boolean isValid(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                characters.push(ch);
            } else if (isMatching(characters, ch, ')', '(')) {
                characters.pop();
            } else if (isMatching(characters, ch, ']', '[')) {
                characters.pop();
            } else if (isMatching(characters, ch, '}', '{')) {
                characters.pop();
            } else {
                return false;
            }
        }

        return characters.isEmpty();
    }

    private static boolean isMatching(Stack<Character> characters, char currentCh, char ch1, char ch2) {
        return currentCh == ch1 && !characters.isEmpty() && characters.peek() == ch2;
    }
}