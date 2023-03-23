package homeworks.homework1;

import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        for (int currentNumber = 1; currentNumber <= 100; currentNumber++) {
            if ((currentNumber % 3 == 0 && currentNumber % 5 == 0)) {
                System.out.println("github");
            } else if (currentNumber % 3 == 0) {
                System.out.println("git");
            } else if (currentNumber % 5 == 0) {
                System.out.println("hub");
            } else {
                System.out.println(currentNumber);
            }
        }
    }

    public static void from1To100() {
        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "github" : "git")
                        : (i % 5 == 0 ? "hub" : Integer.toString(i)))
                .forEach(System.out::println);
    }
}