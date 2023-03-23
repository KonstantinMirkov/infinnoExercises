package homeworks.homework15;

import java.lang.reflect.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws IllegalAccessException {
        Manager m1 = new Manager("Svilen");
        Employee e1 = new Employee("Ivan", m1);

        Manager m2 = new Manager("Refo");
        Employee e2 = new Employee("Daniela", m2);

        Manager m3 = new Manager("Refo");
        Employee e3 = new Employee("Ivan", m3);

        Manager m4 = new Manager("Svilen");
        Employee e4 = new Employee("Ivan", m4);

        Employee e5 = new Employee("Ivan", m1);

        System.out.println(compare(e1, e2)); // => false
        System.out.println(compare(e1, e3)); // => false
        System.out.println(compare(e1, e4)); // => true
        System.out.println(compare(e1, e5)); // => true
    }

    public static boolean compare(Object obj1, Object obj2) throws IllegalAccessException {
        if (obj1 == obj2) {
            return true;
        }

        if (obj1 == null || obj2 == null || obj1.getClass() != obj2.getClass()) {
            return false;
        }

        Field[] fields = obj1.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value1 = field.get(obj1);
            Object value2 = field.get(obj2);

            if (value1 == null && value2 == null) {
                continue;
            } else if (value1 == null || value2 == null) {
                return false;
            }

            if (field.getType().isArray()) {
                if (!Arrays.deepEquals(new Object[] {value1}, new Object[] {value2})) {
                    return false;
                }
            } else if (field.getType().isPrimitive() || field.getType().equals(String.class)) {
                if (!Objects.equals(value1, value2)) {
                    return false;
                }
            } else {
                if (!compare(value1, value2)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static class Manager {
        private String name;

        public Manager(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Employee {
        private String name;
        private Manager manager;

        public Employee(String name, Manager manager) {
            this.name = name;
            this.manager = manager;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Manager getManager() {
            return manager;
        }

        public void setManager(Manager manager) {
            this.manager = manager;
        }
    }
}
