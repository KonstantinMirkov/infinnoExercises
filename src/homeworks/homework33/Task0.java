package homeworks.homework33;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Task0 {
    public static <T> Iterator<T> filter(Iterator<T> iterator, Predicate<T> predicate) {
        return new Iterator<>() {
            private T nextElement;
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                if (hasNext) {
                    while (iterator.hasNext()) {
                        T element = iterator.next();
                        if (predicate.test(element)) {
                            nextElement = element;
                            return true;
                        }
                    }
                    hasNext = false;
                }
                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                hasNext = true;
                return nextElement;
            }
        };
    }
}
