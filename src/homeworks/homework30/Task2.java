package homeworks.homework30;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        MySortedSet<Integer> set = new MySortedSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        // set after adding
        System.out.println(set); // 1, 2, 3, 4, 5

        // subSet
        System.out.println(set.subSet(2, 4)); // 2, 3

        // headSet
        System.out.println(set.headSet(3));// 1, 2

        // tailSet
        System.out.println(set.tailSet(3)); // 3, 4, 5
    }


    public static class MySortedSet<E> extends TreeSet<E> implements SortedSet<E> {

        public MySortedSet() {
            super();
        }

        public MySortedSet(Comparator<? super E> comparator) {
            super(comparator);
        }

        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return super.subSet(fromElement, toElement);
        }

        @Override
        public SortedSet<E> headSet(E toElement) {
            return super.headSet(toElement);
        }

        @Override
        public SortedSet<E> tailSet(E fromElement) {
            return super.tailSet(fromElement);
        }
    }
}