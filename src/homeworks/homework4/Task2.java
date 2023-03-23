package homeworks.homework4;

public class Task2 {
    public static void main(String[] args) {
        Object[] array = {1, 2, 3, 0, 12};
        Object searchElement = 3;
        boolean result = include(array, searchElement);
        System.out.println(result);

        String[] array2 = {"1", "2", "3", "0", "12"};
        String searchElement2 = String.valueOf(3);
        boolean result2 = include(array2, searchElement2);
        System.out.println(result2);
    }

    public static boolean include(Object[] array, Object searchElement) {
        return include(array, searchElement, 0);
    }

    public static boolean include(Object[] array, Object searchElement, int fromIndex) {
        for (int i = fromIndex; i < array.length; i++) {
            if (array[i].equals(searchElement)) {
                return true;
            }
        }
        return false;
    }
}
