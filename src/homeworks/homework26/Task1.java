package homeworks.homework26;

import java.util.*;

public class Task1 {
    private static final int INITIAL_CAPACITY = 16;

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("text1");
        set.add("text2");
        set.add("text3");
        System.out.println("Set size: " + set.size());
        System.out.println("Set contains text1: " + set.contains("text1"));
        System.out.println("Set contains randomText: " + set.contains("randomText"));
        set.remove("text2");
        System.out.println("Set size after removing text2: " + set.size());
    }

    public static class HashSet<E> {
        private LinkedList<E>[] data;
        private int capacity;
        private int size;

        public HashSet() {
            this(INITIAL_CAPACITY);
        }

        public HashSet(Collection<? extends E> c) {
            this();
            for (E e : c) {
                add(e);
            }
        }

        public HashSet(int initialCapacity) {
            capacity = initialCapacity;
            data = new LinkedList[capacity];
            size = 0;
        }

        public boolean add(E e) {
            int bucket = getBucket(e);
            if (data[bucket] == null) {
                data[bucket] = new LinkedList<>();
            }

            if (!data[bucket].contains(e)) {
                data[bucket].add(e);
                size++;
                return true;
            }
            return false;
        }

        public void clear() {
            data = new LinkedList[capacity];
            size = 0;
        }

        public boolean contains(Object o) {
            int bucket = getBucket(o);
            return data[bucket] != null && data[bucket].contains(o);
        }

        public boolean remove(Object o) {
            int bucket = getBucket(o);
            if (data[bucket] != null && data[bucket].remove(o)) {
                size--;
                return true;
            }
            return false;
        }

        public Iterator<E> iterator() {
            return new HashSetIterator();
        }

        public int size() {
            return size;
        }

        private int getBucket(Object o) {
            return Math.abs(o.hashCode()) % capacity;
        }

        private class HashSetIterator implements Iterator<E> {
            private int currentIndex;
            private Iterator<E> currentIterator;

            public HashSetIterator() {
                currentIndex = 0;
                currentIterator = null;
                findNextIterator();
            }

            @Override
            public boolean hasNext() {
                return currentIterator != null && currentIterator.hasNext();
            }

            @Override
            public E next() {
                E next = currentIterator.next();
                if (!currentIterator.hasNext()) {
                    findNextIterator();
                }
                return next;
            }

            private void findNextIterator() {
                while (currentIndex < capacity && (data[currentIndex] == null || !data[currentIndex].iterator().hasNext())) {
                    currentIndex++;
                }

                if (currentIndex < capacity) {
                    currentIterator = data[currentIndex].iterator();
                } else {
                    currentIterator = null;
                }
            }
        }

        public static class LinkedList<E> {
            private Node<E> elementData;
            private int size;

            public LinkedList() {
                elementData = null;
                size = 0;
            }

            public Iterator<E> iterator() {
                return new LinkedListIterator();
            }

            public boolean add(E e) {
                if (elementData == null) {
                    elementData = new Node<>(e);
                }

                Node<E> current = elementData;
                while (current.next != null) {
                    current = current.next;
                }

                current.next = new Node<>(e);

                size++;
                return true;
            }

            public void add(int index, E element) {
                if (index < 0 || index > size) {
                    throw new IndexOutOfBoundsException();
                }

                if (index == 0) {
                    elementData = new Node<>(element, elementData);
                } else {
                    Node<E> current = elementData;
                    for (int i = 0; i < index - 1; i++) {
                        current = current.next;
                    }

                    current.next = new Node<>(element, current.next);
                }

                size++;
            }

            public boolean contains(Object o) {
                Node<E> current = elementData;
                while (current != null) {
                    if (current.data.equals(o)) {
                        return true;
                    }
                    current = current.next;
                }
                return false;
            }

            public E remove() {
                if (elementData == null) {
                    throw new NoSuchElementException();
                }
                E data = elementData.data;
                elementData = elementData.next;
                size--;
                return data;
            }

            public E remove(int index) {
                if (index < 0 || index >= size) {
                    throw new IndexOutOfBoundsException();
                }
                if (index == 0) {
                    return remove();
                }
                Node<E> current = elementData;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                E data = current.next.data;
                current.next = current.next.next;
                size--;
                return data;
            }

            public boolean remove(Object o) {
                if (elementData == null) {
                    return false;
                }
                if (elementData.data.equals(o)) {
                    elementData = elementData.next;
                    size--;
                    return true;
                }
                Node<E> current = elementData;
                while (current.next != null) {
                    if (current.next.data.equals(o)) {
                        current.next = current.next.next;
                        size--;
                        return true;
                    }
                    current = current.next;
                }
                return false;
            }


            private static class Node<E> {
                E data;
                Node<E> next;

                Node(E data) {
                    this(data, null);
                }

                Node(E data, Node<E> next) {
                    this.data = data;
                    this.next = next;
                }
            }

            private class LinkedListIterator implements Iterator<E> {
                private Node<E> current;

                LinkedListIterator() {
                    current = elementData;
                }

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public E next() {
                    E data = current.data;
                    current = current.next;
                    return data;
                }
            }
        }
    }
}