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
        System.out.println(set.subSet(3, 1)); // 2, 3

        // headSet
        System.out.println(set.headSet(3));// 1, 2

        // tailSet
        System.out.println(set.tailSet(3)); // 3, 4, 5
    }


    public static class MySortedSet<E extends Comparable<E>> implements SortedSet<E> {
        private Node<E> root;

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(E e) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        private static class Node<E> {
            E element;
            Node<E> left;
            Node<E> right;

            Node(E element) {
                this.element = element;
            }
        }

        @Override
        public Comparator<? super E> comparator() {
            return null;
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            MySortedSet<E> result = new MySortedSet<>();
            Stack<Node<E>> stack = new Stack<>();
            Node<E> current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                int cmpFrom = fromElement.compareTo(current.element);
                int cmpTo = toElement.compareTo(current.element);
                if (cmpFrom <= 0 && cmpTo > 0) result.add(current.element);
                current = current.right;
            }
            return result;
        }

        public SortedSet<E> headSet(E toElement) {
            MySortedSet<E> result = new MySortedSet<>();
            Stack<Node<E>> stack = new Stack<>();
            Node<E> current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                int cmp = toElement.compareTo(current.element);
                if (cmp > 0) result.add(current.element);
                current = current.right;
            }
            return result;
        }

        public SortedSet<E> tailSet(E fromElement) {
            MySortedSet<E> result = new MySortedSet<>();
            Stack<Node<E>> stack = new Stack<>();
            Node<E> current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                int cmp = fromElement.compareTo(current.element);
                if (cmp <= 0) result.add(current.element);
                current = current.right;
            }
            return result;
        }

        @Override
        public E first() {
            return null;
        }

        @Override
        public E last() {
            return null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Iterator<E> it = new Iterator<E>() {
                Stack<Node<E>> stack = new Stack<>();
                Node<E> current = root;

                @Override
                public boolean hasNext() {
                    return current != null || !stack.isEmpty();
                }

                @Override
                public E next() {
                    while (current != null) {
                        stack.push(current);
                        current = current.left;
                    }
                    Node<E> node = stack.pop();
                    current = node.right;
                    return node.element;
                }
            };

            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}