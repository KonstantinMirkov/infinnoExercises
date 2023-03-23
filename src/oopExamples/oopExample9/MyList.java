package oopExamples.oopExample9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyList {
    private List<Integer> myList;

    public MyList() {
        myList = new ArrayList<>();
    }

    public void add(int value) {
        myList.add(value);

    }

    public void remove(int value) {
        myList.remove(value);
    }

    public Iterator<Integer> iterator() {
        return myList.iterator();
    }

    public double average() {
        int sum = 0;
        int count = 0;

        Iterator<Integer> iterator = iterator();
        while (iterator().hasNext()) {
            Integer value = iterator.next();
            sum += value;
            count++;
        }
        return (double) sum / count;
    }
}
