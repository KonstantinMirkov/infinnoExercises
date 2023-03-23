package oopExamples.oopExample9;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int[] elements = new int[]{8, 12, 7, 15, 20, 5};

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for (int number : elements) {
            integerArrayList.add(number);
        }

        System.out.println(sum(integerArrayList));
    }

    public static int sum(ArrayList<Integer> integerArrayList) {
        int sum = 0;

        Iterator<Integer> iterator = integerArrayList.iterator();

        while (iterator.hasNext()) {
            int value = iterator.next();

            if (value > 10) {
                sum += value;
            }
        }
        return sum;
    }
}
