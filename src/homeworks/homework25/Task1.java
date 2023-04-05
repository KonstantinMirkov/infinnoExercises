package homeworks.homework25;

import java.lang.reflect.Array;
import java.util.*;

public class Task1 {
    public static class LinkedList<E> {
        private Node<E> elementData;
        private int size;

        public LinkedList() {
            elementData = null;
            size = 0;
        }

        public LinkedList(Collection<? extends E> c) {
            this();
            addAll(c);
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

        public boolean addAll(Collection<? extends E> c) {
            boolean changed = false;
            for (E e : c) {
                changed |= add(e);
            }
            return changed;
        }

        public boolean addAll(int index, Collection<? extends E> c) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            if (c.isEmpty()) {
                return false;
            }
            Iterator<? extends E> iterator = c.iterator();

            add(index++, iterator.next());
            while (iterator.hasNext()) {
                add(index++, iterator.next());
            }
            return true;
        }

        public void addFirst(E e) {
            elementData = new Node<>(e, elementData);
            size++;
        }

        public void addLast(E e) {
            add(e);
        }

        public void clear() {
            elementData = null;
            size = 0;
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

        public E element() {
            if (elementData == null) {
                throw new NoSuchElementException();
            }
            return elementData.data;
        }

        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            Node<E> current = elementData;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        public E getFirst() {
            return element();
        }

        public E getLast() {
            if (elementData == null) {
                throw new NoSuchElementException();
            }

            Node<E> current = elementData;
            while (current.next != null) {
                current = current.next;
            }
            return current.data;
        }

        public int indexOf(Object o) {
            int index = 0;
            Node<E> current = elementData;
            while (current != null) {
                if (current.data.equals(o)) {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }

        public boolean offer(E e) {
            return add(e);
        }

        public boolean offerFirst(E e) {
            addFirst(e);
            return true;
        }

        public boolean offerLast(E e) {
            return add(e);
        }

        public E peek() {
            if (elementData == null) {
                return null;
            }
            return elementData.data;
        }

        public E peekFirst() {
            return peek();
        }

        public E peekLast() {
            if (elementData == null) {
                return null;
            }
            Node<E> current = elementData;
            while (current.next != null) {
                current = current.next;
            }
            return current.data;
        }

        public void push(E e) {
            addFirst(e);
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

        public E removeFirst() {
            return remove();
        }

        public boolean removeFirstOccurrence(Object o) {
            return remove(o);
        }

        public E removeLast() {
            if (elementData == null) {
                throw new NoSuchElementException();
            }
            if (elementData.next == null) {
                E data = elementData.data;
                elementData = null;
                size--;
                return data;
            }
            Node<E> current = elementData;
            while (current.next.next != null) {
                current = current.next;
            }
            E data = current.next.data;
            current.next = null;
            size--;
            return data;
        }

        public Object[] toArray() {
            Object[] array = new Object[size];
            int index = 0;
            Node<E> current = elementData;
            while (current != null) {
                array[index++] = current.data;
                current = current.next;
            }
            return array;
        }

        public <T> T[] toArray(T[] a) {
            if (a.length < size) {
                a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
            }
            int index = 0;
            Node<E> current = elementData;
            while (current != null) {
                a[index++] = (T) current.data;
                current = current.next;
            }
            if (a.length > size) {
                a[size] = null;
            }
            return a;
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
