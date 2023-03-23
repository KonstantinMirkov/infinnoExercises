package genericsExample;

import java.util.HashSet;

public class UniqueCollectionExample {
    public static void main(String[] args) {
        UniqueCollection<String> stringsUniqueCollection = new UniqueCollection<>();

        stringsUniqueCollection.add("str1");
        stringsUniqueCollection.add("str2");
        stringsUniqueCollection.remove("str2");
        //..
    }

    public static class UniqueCollection<T> {
        private HashSet<T> elements;

        public UniqueCollection() {
            elements = new HashSet<>();
        }

        public void add(T element) {
            elements.add(element);
        }

        public void remove(T element) {
            elements.remove(element);
        }

        public boolean contains(T element) {
            return elements.contains(element);
        }

        public int size() {
            return elements.size();
        }
    }
}
