package homeworks;

import java.util.*;
import java.util.function.Predicate;

public class Task1 {
    public static class MyArrayList<E> {
        private static final int INITIAL_CAPACITY = 10;
        private int size;
        private Object[] elementData;

        public MyArrayList(int initialCapacity) {
            super();
            if (initialCapacity < 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
            }

            this.elementData = new Object[initialCapacity];
        }

        public MyArrayList() {
            this(INITIAL_CAPACITY);
        }

        public boolean add(E e) {
            ensureCapacity(size + 1);
            elementData[size++] = e;
            return true;
        }

        public void add(int index, E element) {
            if (index > size || index < 0) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            ensureCapacity(size + 1);
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = element;
            size++;
        }

        public void clear() {
            for (int i = 0; i < size; i++) {
                elementData[i] = null;
            }
            size = 0;
        }

        public boolean contains(Object o) {
            return indexOf(o) >= 0;
        }

        public int indexOf(Object o) {
            if (o == null) {
                for (int i = 0; i < size; i++) {
                    if (elementData[i] == null) {
                        return i;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (o.equals(elementData[i])) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public void ensureCapacity(int minCapacity) {
            int oldCapacity = elementData.length;
            if (minCapacity > oldCapacity) {
                int newCapacity = (oldCapacity * 3) / 2 + 1;
                if (newCapacity < minCapacity) {
                    newCapacity = minCapacity;
                }
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
        }

        public E get(int index) {
            if (index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            return (E) elementData[index];
        }

        public int lastIndexOf(Object o) {
            if (o == null) {
                for (int i = size - 1; i >= 0; i--) {
                    if (elementData[i] == null) {
                        return i;
                    }
                }
            } else {
                for (int i = size - 1; i >= 0; i--) {
                    if (o.equals(elementData[i])) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public E remove(int index) {
            if (index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            E oldValue = (E) elementData[index];

            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elementData, index + 1, elementData, index,
                        numMoved);
            }

            elementData[--size] = null;
            return oldValue;
        }

        public boolean remove(Object o) {
            if (o == null) {
                for (int index = 0; index < size; index++) {
                    if (elementData[index] == null) {
                        fastRemove(index);
                        return true;
                    }
                }
            } else {
                for (int index = 0; index < size; index++) {
                    if (o.equals(elementData[index])) {
                        fastRemove(index);
                        return true;
                    }
                }
            }
            return false;
        }

        private void fastRemove(int index) {
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elementData, index + 1, elementData, index,
                        numMoved);
            }
            elementData[--size] = null;
        }

        public boolean removeIf(Predicate<? super E> filter) {
            Objects.requireNonNull(filter);
            int removeCount = 0;
            final BitSet removeSet = new BitSet(size);
            for (int i = 0; i < size; i++) {
                if (filter.test((E) elementData[i])) {
                    removeSet.set(i);
                    removeCount++;
                }
            }

            if (removeCount > 0) {
                int newSize = size - removeCount;
                for (int i = 0, j = 0; (i < size) && (j < newSize); i++, j++) {
                    i = removeSet.nextClearBit(i);
                    elementData[j] = elementData[i];
                }

                for (int k = newSize; k < size; k++) {
                    elementData[k] = null;
                }

                size = newSize;
                return true;
            }
            return false;
        }

        protected void removeRange(int fromIndex, int toIndex) {
            int numMoved = size - toIndex;
            System.arraycopy(elementData, toIndex, elementData, fromIndex,
                    numMoved);

            int newSize = size - (toIndex - fromIndex);
            while (size != newSize) {
                elementData[--size] = null;
            }
        }

        public SubList<E> subList(int fromIndex, int toIndex) {
            return new SubList<>(fromIndex, toIndex);
        }

        public void trimToSize() {
            if (size < elementData.length) {
                elementData = Arrays.copyOf(elementData, size);
            }
        }

        public Object[] toArray() {
            Object[] result = new Object[size];

            System.arraycopy(elementData, 0, result, 0, size);

            return result;
        }

        public <T> T[] toArray(T[] arr) {
            if (arr.length < size) {
                return (T[]) Arrays.copyOf(elementData, size, arr.getClass());
            }

            System.arraycopy(elementData, 0, arr, 0, size);

            if (arr.length > size) {
                arr[size] = null;
            }
            return arr;
        }

        public boolean retainAll(Collection<E> c) {
            if (c == null) {
                throw new NullPointerException("collection is null");
            }

            MyArrayListIterator<E> iterator = new MyArrayListIterator<>();

            boolean found = false;
            while (iterator.hasNext()) {
                if (!c.contains(iterator.next())) {
                    iterator.remove();
                    found = true;
                }
            }
            return found;
        }

        public boolean removeAll(Collection<?> c) {
            MyArrayListIterator<E> e = new MyArrayListIterator<>();

            boolean modified = false;
            while (e.hasNext()) {
                if (c.contains(e.next())) {
                    e.remove();
                    modified = true;
                }
            }
            return modified;
        }
    }

    public static class MyArrayListIterator<E> implements Iterator<E> {
        private E[] elementData;
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < elementData.length;
        }

        @Override
        public E next() {
            return elementData[currentIndex++];
        }
    }

    private static class SubList<E> extends AbstractList<E> {
        private AbstractList<E> parent;
        private final int parentOffset;
        int size;

        SubList(AbstractList<E> parent, int fromIndex, int toIndex) {
            this.parent = parent;
            this.parentOffset = fromIndex;
            this.size = toIndex - fromIndex;
        }

        SubList(int fromIndex, int toIndex) {
            this.parentOffset = fromIndex;
            this.size = toIndex - fromIndex;
        }


        @Override
        public E get(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            }

            return parent.get(parentOffset + index);
        }

        public List<E> subList(int fromIndex, int toIndex) {
            return new SubList(fromIndex, toIndex);
        }


        private String outOfBoundsMsg(int index) {
            return "Index: " + index + ", Size: " + this.size;
        }

        @Override
        public int size() {
            return this.size;
        }
    }
}
