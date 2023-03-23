package homeworks.homework17;

import java.util.Comparator;

public class Task1 {
    public static void main(String[] args) {
        Employee[] people = {
                new Employee("Ivan", 25),
                new Employee("Niki", 33),
                new Employee("Desi", 12)
        };

        Comparator<Employee> comp = Comparator.comparingInt(Employee::getAge);

        Employee oldest = max(people, comp);
        System.out.println(oldest);
    }

    public static <T> T max(T[] arr, Comparator<? super T> compare) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (compare.compare(arr[i], max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name = " + name +
                    ", age = " + age +
                    '}';
        }
    }
}

