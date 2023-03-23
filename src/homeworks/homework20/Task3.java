package homeworks.homework20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Task3 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        remove(list, e -> e % 2 == 0);
        System.out.println(list); // [1, 3]
    }

    public static <T> void remove(ArrayList<T> list, Predicate<T> f) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null.");
        }

        if (list.size() == 0) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (f.test(list.get(i))) {
                list.remove(i);
            }
        }
    }
}