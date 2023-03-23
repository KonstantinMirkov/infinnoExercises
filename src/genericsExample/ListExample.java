package genericsExample;

import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<>();
        integerMyList.add(12);
        integerMyList.remove(12);
        System.out.println(integerMyList);
    }

    public static class MyList<T extends Number> {
        private ArrayList<T> numList;

        public MyList() {
            numList = new ArrayList<>();
        }

        public void add(T element) {
            numList.add(element);
        }

        public void remove(T element) {
            numList.remove(element);
        }

        @Override
        public String toString() {
            return "MyList{" +
                    "numList=" + numList +
                    '}';
        }
    }
}
