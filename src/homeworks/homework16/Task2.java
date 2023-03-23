package homeworks.homework16;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Stoyan");
        Employee e2 = new Employee("Ivan");
        Employee e3 = new Employee("Petar");
        Employee e4 = new Employee("Albena");
        Employee e5 = new Employee("Georgi");

        Employee[] employees = {e1, e2, e3, e4, e5};


        Condition noACondition = o -> {
            Employee e = (Employee) o;
            return !e.getName().toLowerCase().contains("a");
        };

        Object[] filteredEmployees = filter(employees, noACondition);

        for (Object o : filteredEmployees) {
            Employee e = (Employee) o;
            System.out.println(e.getName()); // Georgi
        }
    }

    public static Object[] filter(Object[] employeeArr, Condition condition) {
        if (employeeArr == null) {
            throw new IllegalArgumentException("The employees array cannot be null.");
        }

        List<Object> filteredList = new ArrayList<>();
        for (Object employee : employeeArr) {
            if (condition.isValid(employee)) {
                filteredList.add(employee);
            }
        }
        return filteredList.toArray();
    }

    public static class Employee implements Comparable<Employee> {
        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Employee e) {
            return this.name.compareTo(e.name);
        }
    }

    interface Condition {
        boolean isValid(Object o);
    }
}
