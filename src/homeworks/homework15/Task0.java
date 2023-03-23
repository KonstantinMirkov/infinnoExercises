package homeworks.homework15;

import java.util.ArrayList;
import java.util.List;

public class Task0 {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4};
        List<Integer> list = new ArrayList<>(List.of(a));
        splice(list, 1, 1);
        System.out.println(list); // [1, 3, 4]

        List<Integer> list2 = new ArrayList<>(List.of(a));
        splice(list2, 1, 2, 5, 6);
        System.out.println(list2); // [1, 5, 6, 4]

        List<Integer> list3 = new ArrayList<>(List.of(a));
        splice(list3, 1);
        System.out.println(list3); // [1]

        List<Integer> list4 = new ArrayList<>(List.of(a));
        splice(list4, 0, 1, 7, 8, 9);
        System.out.println(list4); // [7, 8, 9, 2, 3, 4]

        try {
            splice(null, 2, 2, 7, 8, 9);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // The array of elements cannot be null.
        }

        try {
            List<Integer> list5 = new ArrayList<>(List.of(a));
            splice(list5, 12, 2, 7, 8, 9);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Start cannot be greater than the array size.
        }

        try {
            List<Integer> list6 = new ArrayList<>(List.of(a));
            splice(list6, -12, 2, 7, 8, 9);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Start and delete count cannot be negative.
        }

        try {
            List<Integer> list7 = new ArrayList<>(List.of(a));
            splice(list7, -12, -2, 7, 8, 9);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Start and delete count cannot be negative.
        }
    }

    public static <E> List<E> splice(List<E> arr, int start) {
        return splice(arr, start, arr.size() - start);
    }

    public static <E> List<E> splice(List<E> arr, int start, int deleteCount) {
        ensureArrCannotBeNull(arr);
        ensureStartNotGreaterThanArrSize(arr, start);
        ensureStartOrDelCountNotNegative(start, deleteCount);

        List<E> deletedItems = new ArrayList<>();

        int end = Math.min(start + deleteCount, arr.size());
        int newSize = arr.size() - deleteCount;
        if (newSize > arr.size()) {
            for (int i = start; i < end; i++) {
                deletedItems.add(arr.get(i));
            }
        }

        while (arr.size() > newSize) {
            arr.subList(start, end).clear();
        }

        return deletedItems;
    }

    public static <E> List<E> splice(List<E> arr, int start, int deleteCount, E... items) {
        List<E> deletedItems = splice(arr, start, deleteCount);

        for (E item : items) {
            arr.add(start++, item);
        }

        return deletedItems;
    }

    private static void ensureStartOrDelCountNotNegative(int start, int deleteCount) {
        if (start < 0 || deleteCount < 0) {
            throw new IllegalArgumentException("Start and delete count cannot be negative.");
        }
    }

    private static <E> void ensureStartNotGreaterThanArrSize(List<E> arr, int start) {
        if (start > arr.size()) {
            throw new IndexOutOfBoundsException("Start cannot be greater than the array size.");
        }
    }

    private static <E> void ensureArrCannotBeNull(List<E> arr) {
        if (arr == null) {
            throw new NullPointerException("The array of elements cannot be null.");
        }
    }
}
