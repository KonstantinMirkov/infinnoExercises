package homeworks.homework32;

import java.util.*;
import java.util.function.*;

public class Task3 {
    interface Stream<T> {
        long count();

        Stream<T> filter(Predicate<? super T> predicate);

        static <T> Stream<T> generate(Supplier<T> s) {
            return MyStream.generate(s);
        }

        static <T> Stream<T> iterate(T seed, UnaryOperator<T> f) {
            return iterate(seed, f);
        }

        static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next) {
            return iterate(seed, hasNext, next);
        }

        <R> Stream<R> map(Function<? super T, ? extends R> mapper);

        static <T> Stream<T> of(T... values) {
            return of(values);
        }
    }

    public static class MyStream<T> implements Stream<T> {
        private final Iterator<T> iterator;

        public MyStream(Iterator<T> iterator) {
            this.iterator = iterator;
        }

        @Override
        public long count() {
            long count = 0;

            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }

            return count;
        }

        @Override
        public Stream<T> filter(Predicate<? super T> predicate) {
            Objects.requireNonNull(predicate);

            List<T> result = new ArrayList<>();
            while (iterator.hasNext()) {
                T item = iterator.next();
                if (predicate.test(item)) {
                    result.add(item);
                }
            }

            return new MyStream<>(result.iterator());
        }

        @Override
        public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
            Objects.requireNonNull(mapper);

            List<R> result = new ArrayList<>();
            while (iterator.hasNext()) {
                T item = iterator.next();
                result.add(mapper.apply(item));
            }

            return new MyStream<>(result.iterator());
        }

        @SafeVarargs
        public static <T> Stream<T> of(T... values) {
            Objects.requireNonNull(values);

            List<T> result = new ArrayList<>(Arrays.asList(values));

            return new MyStream<>(result.iterator());
        }

        public static <T> Stream<T> generate(Supplier<T> s) {
            Objects.requireNonNull(s);

            return new MyStream<>(new Iterator<>() {
                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public T next() {
                    return s.get();
                }
            });
        }

        public static <T> Stream<T> iterate(T seed, UnaryOperator<T> f) {
            Objects.requireNonNull(f);

            return new MyStream<>(new Iterator<>() {
                private T current = seed;

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public T next() {
                    T next = current;
                    current = f.apply(current);
                    return next;
                }
            });
        }

        public static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next) {
            Objects.requireNonNull(hasNext);
            Objects.requireNonNull(next);

            return new MyStream<>(new Iterator<>() {
                private T current = seed;
                private boolean hasNextValue = true;

                @Override
                public boolean hasNext() {
                    return hasNextValue;
                }

                @Override
                public T next() {
                    T next = current;
                    hasNextValue = hasNext.test(current);
                    if (hasNextValue) {
                        current = next;
                    }
                    return next;
                }
            });
        }

        private T next(T current) {
            try {
                return current != null ? iterator.next() : null;
            } catch (Exception e) {
               return null;
            }
        }
    }
}
