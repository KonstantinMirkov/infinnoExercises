package homeworks.homework16;

import java.util.Comparator;

public class Task1 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Stoyan");
        Employee e2 = new Employee("Ivan");
        Employee e3 = new Employee("Petar");
        Employee e4 = new Employee("Albena");

        Employee[] ea = {e1, e2, e3, e4};

        sort(ea, Comparable::compareTo);
        for (Employee e : ea) {
            System.out.println(e.getName());
        }
    }

    public static void sort(Comparable[] employeeArr, Comparator<Comparable> cmp) {
        if (employeeArr == null || employeeArr.length == 0) {
            throw new IllegalArgumentException("The employee array cannot be null or empty.");
        }

        int n = employeeArr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (cmp.compare(employeeArr[j], employeeArr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            Comparable temp = employeeArr[i];
            employeeArr[i] = employeeArr[minIdx];
            employeeArr[minIdx] = temp;
        }
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
}
