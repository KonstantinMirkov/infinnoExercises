package tests.test8;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        // create a new CircularArrayQueue with capacity 5
        CircularArrayQueue<Integer> queue1 = new CircularArrayQueue<>(5);
        // add
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);

        // add to full queue2
        try {
            queue1.add(6);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Queue is full.
        }

        // remove
        System.out.println(queue1.remove()); // 1
        System.out.println(queue1.remove()); // 2

        System.out.println(queue1.remove(2));

//        // print the remaining elements
//        while (!queue1.isEmpty()) {
//            System.out.print(queue1.remove() + " "); // 3 4 5
//        }
//        System.out.println();
//
//
//
//        // try to remove an element from an empty queue2
//        try {
//            queue1.remove();
//        } catch (NoSuchElementException e) {
//            System.out.println(e.getMessage()); // Queue is empty.
//        }
//
//        CircularArrayQueue<Integer> queue2 = new CircularArrayQueue<>(5);
//        Integer[] arr = {5, 6, 7, 8, 9};
//        boolean addAll = queue2.addAll(Arrays.asList(arr));
//        System.out.println(addAll); // true
//
//        queue2.clear();
//        System.out.println(Arrays.toString(queue2.elements));
    }

    public static class CircularArrayQueue<E> implements Queue<E> {
        private E[] elements;
        private int head;
        private int tail;
        private int size;
        private int modCount;

        public CircularArrayQueue(int capacity) {
            elements = (E[]) new Object[capacity];
            head = 0;
            tail = 0;
            size = 0;
            modCount = 0;
        }

        @Override
        public boolean add(E e) {
            if (size == elements.length) {
                return false;
            }

            elements[tail] = e;
            tail = (tail + 1) % elements.length;
            size++;
            return true;
        }

        @Override
        public E remove() {
            if (size == 0) {
                throw new NoSuchElementException("Queue is empty.");
            }

            E element = elements[head];
            head = (head + 1) % elements.length;
            size--;
            return element;
        }

        @Override
        public boolean remove(Object o) {
            if (size == elements.length) {
                return false;
            }

            elements[head] = (E) o;
            head = (head + 1) % elements.length;
            size--;
            return true;
        }

        @Override
        public boolean contains(Object o) {
            for (int i = head; i != tail; i = (i + 1) % elements.length) {
                if (elements[i].equals(o)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            for (Object o : c) {
                if (!contains(o)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            if (c.size() > (elements.length - size)) {
                throw new IllegalStateException("Not enough capacity.");
            }

            for (E element : c) {
                add(element);
            }
            return true;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            if (c == null) {
                throw new NullPointerException("Collection cannot be null.");
            }

            if (c.isEmpty()) {
                return false;
            }

            boolean modified = false;
            for (Object o : c) {
                while (contains(o)) {
                    remove(o);
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            //TODO
            return false;
        }

        @Override
        public void clear() {
            for (int i = head; i != tail; i = (i + 1) % elements.length) {
                elements[i] = null;
            }
            head = 0;
            tail = 0;
            size = 0;
            modCount++;
        }

        @Override
        public boolean offer(E e) {
            if (size == elements.length) {
                return false;
            }

            elements[tail] = e;
            tail = (tail + 1) % elements.length;
            size++;
            return true;
        }


        @Override
        public E poll() {
            if (size == 0) {
                return null;
            }

            E element = elements[head];
            head = (head + 1) % elements.length;
            size--;
            return element;
        }

        @Override
        public E element() {
            if (size == 0) {
                throw new NoSuchElementException("Queue is empty");
            }
            return elements[head];
        }

        @Override
        public E peek() {
            if (size == 0) {
                return null;
            }
            return elements[head];
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private int index = head;
                private int count = 0;
                private final int expectedModCount = modCount;

                @Override
                public boolean hasNext() {
                    return count < size;
                }

                @Override
                public E next() {
                    if (modCount != expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    E element = elements[index];
                    index = (index + 1) % elements.length;
                    count++;
                    return element;
                }
            };
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return a;
        }
    }
}
