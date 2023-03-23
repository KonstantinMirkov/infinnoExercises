package homeworks.homework5;

public class Task1 {
    public static void main(String[] args) throws Exception {
        Object[] array = {1, 0, 3, 0, 12};
        Object searchElement = 0;
        int result = lastIndexOf(array, searchElement);
        System.out.println(result);

        String[] array2 = {"1", "0", "3", "0", "12"};
        String searchElement2 = String.valueOf(0);
        int fromIndex = 2;
        result = lastIndexOf(array2, searchElement2, fromIndex);
        System.out.println(result);

        Object[] array3 = {1, 2, 3, 0, 12};
        Object searchElement3 = 4;
        result = lastIndexOf(array3, searchElement3);
        System.out.println(result);
    }

    public static int lastIndexOf(Object[] array, Object searchElement) throws Exception {
        return lastIndexOf(array, searchElement, array.length - 1);
    }

    public static int lastIndexOf(Object[] array, Object searchElement, int fromIndex) throws Exception {
        if (fromIndex < 0 || fromIndex >= array.length) {
            throw new Exception("invalid parameter");
        }

        for (int i = fromIndex; i >= 0; i--) {
            if (array[i].equals(searchElement)) {
                return i;
            }
        }

        return -1;
    }
}
