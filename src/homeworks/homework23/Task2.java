package homeworks.homework23;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Collection<Integer> c1 = Arrays.asList(1, 3, 5, 7);
        Collection<Integer> c2 = Arrays.asList(2, 4, 6, 8);
        Collection<Integer> c = union(c1, c2);
        System.out.println(c); // 1, 2, 3, 4, 5, 6, 7, 8
    }

    public static <T extends Comparable<? super T>> Collection<T> union(Collection<T> c1, Collection<T> c2) {
        List<T> result = new ArrayList<>();
        Iterator<T> it1 = c1.iterator();
        Iterator<T> it2 = c2.iterator();

        T e1 = getE(it1);
        T e2 = getE(it2);

        while (e1 != null || e2 != null) {
            if (e1 == null) {
                result.add(e2);
                e2 = getE(it2);
            } else if (e2 == null) {
                result.add(e1);
                e1 = getE(it1);
            } else if (e1.compareTo(e2) < 0) {
                result.add(e1);
                e1 = getE(it1);
            } else {
                result.add(e2);
                e2 = getE(it2);
            }
        }
        return result;
    }

    private static <T extends Comparable<? super T>> T getE(Iterator<T> it) {
        return it.hasNext() ? it.next() : null;
    }
}
