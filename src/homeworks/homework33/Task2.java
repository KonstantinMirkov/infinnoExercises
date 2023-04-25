package homeworks.homework33;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task2 {
    public static class MyStream<T> {
        private final List<T> list;

        public MyStream(List<T> list) {
            this.list = list;
        }

        public void forEach(Consumer<? super T> action) {
            for (T t : list) {
                action.accept(t);
            }
        }

        public <R> MyStream<R> flatMap(Function<? super T, ? extends MyStream<? extends R>> mapper) {
            List<R> result = new ArrayList<>();
            for (T t : list) {
                MyStream<? extends R> stream = mapper.apply(t);
                stream.forEach(result::add);
            }
            return new MyStream<>(result);
        }

        public MyStream<T> limit(int maxSize) {
            List<T> result = new ArrayList<>();
            int count = 0;
            for (T t : list) {
                if (count < maxSize) {
                    result.add(t);
                    count++;
                } else {
                    break;
                }
            }
            return new MyStream<>(result);
        }

        public MyStream<T> distinct() {
            Set<T> set = new HashSet<>();
            List<T> result = new ArrayList<>();
            for (T t : list) {
                if (set.add(t)) {
                    result.add(t);
                }
            }
            return new MyStream<>(result);
        }

        public MyStream<T> peek(Consumer<? super T> action) {
            List<T> result = new ArrayList<>();
            for (T t : list) {
                action.accept(t);
                result.add(t);
            }
            return new MyStream<>(result);
        }

        public Optional<T> max(Comparator<? super T> comparator) {
            return list.stream().max(comparator);
        }

        public Optional<T> min(Comparator<? super T> comparator) {
            return list.stream().min(comparator);
        }

        public boolean anyMatch(Predicate<? super T> predicate) {
            return list.stream().anyMatch(predicate);
        }

        public boolean allMatch(Predicate<? super T> predicate) {
            return list.stream().allMatch(predicate);
        }

        public boolean noneMatch(Predicate<? super T> predicate) {
            return list.stream().noneMatch(predicate);
        }

        public Optional<T> findFirst() {
            return list.stream().findFirst();
        }
    }
}
