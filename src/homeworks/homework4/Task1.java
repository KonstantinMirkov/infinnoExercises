package homeworks.homework4;

public class Task1 {
    public static void main(String[] args) {
        Object[] array = {1, 2, 3, 0, 12};
        Object searchElement = 3;
        int index = indexOf(array, searchElement);
        System.out.println(index);

        String[] array2 = {"1", "2", "3", "0", "12"};
        String searchElement2 = String.valueOf(3);
        int index2 = indexOf(array2, searchElement2);
        System.out.println(index2);
    }

    public static int indexOf(Object[] array, Object searchElement) {
        return indexOf(array, searchElement, 0);
    }

    public static int indexOf(Object[] array, Object searchElement, int fromIndex) {
        if (fromIndex < 0 || fromIndex >= array.length) {
            fromIndex = 0;
        }
        for (int i = fromIndex; i < array.length; i++) {
            if (array[i].equals(searchElement)) {
                return i;
            }
        }
        return -1;
    }
}
