package genericsExample;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(2);
        integerStack.push(5);
        System.out.println(integerStack.pop());

        Stack<String> stringStack = new Stack<>();

        stringStack.push("str1");
        stringStack.push("str2");

        System.out.println(stringStack.pop());
        System.out.println(stringStack.isEmpty());
    }

    public static class Stack<T> {
        private ArrayList<T> elements;


        public Stack() {
            elements = new ArrayList<>();
        }

        public void push(T element) {
            elements.add(element);
        }

        public T pop() {
            if (elements.isEmpty()) {
                throw new EmptyStackException();
            }
            return elements.remove(elements.size() - 1);
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }
    }
}
