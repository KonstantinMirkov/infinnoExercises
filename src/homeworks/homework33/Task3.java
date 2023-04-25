package homeworks.homework33;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Task3 {
    public static class CustomOptional<T> {

        private final T value;

        public CustomOptional(T value) {
            this.value = value;
        }

        public static <T> CustomOptional<T> of(T value) {
            return new CustomOptional<>(value);
        }

        public static <T> CustomOptional<T> empty() {
            return new CustomOptional<>(null);
        }

        public T get() {
            if (value == null) {
                throw new NoSuchElementException("No value present");
            }
            return value;
        }

        public boolean isPresent() {
            return value != null;
        }

        public void ifPresent(Consumer<? super T> consumer) {
            if (value != null) {
                consumer.accept(value);
            }
        }

        public T orElse(T other) {
            return value != null ? value : other;
        }

        public T orElseGet(Supplier<? extends T> supplier) {
            return value != null ? value : supplier.get();
        }

        public <X extends Throwable> T orElseThrow(Supplier<? extends X> supplier) throws X {
            if (value != null) {
                return value;
            } else {
                throw supplier.get();
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomOptional)) {
                return false;
            }
            CustomOptional<?> other = (CustomOptional<?>) obj;
            return Objects.equals(value, other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return value != null ? "[" + value + "]" : "CustomOptional.empty";
        }
    }
}
