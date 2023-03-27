package tests.test6;

import java.lang.reflect.Field;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Employee e = new Employee("Ivan");
        String[] sa = {"hello", "again"};
        String[] res = strings("now", sa, e); //now hello again Ivan
        for (String s : res) {
            System.out.println(s);
        }

        Employee e2 = new Employee("");
        String[] sa2 = {"", null};
        String[] res2 = strings("w", sa2, e2); // w
        for (String s2 : res2) {
            System.out.println(s2);
        }
    }

    public static String[] strings(Object... objects) {
        List<String> result = new ArrayList<>();
        for (Object obj : objects) {
            extractStrings(obj, result);
        }
        return result.toArray(new String[0]);
    }

    private static void extractStrings(Object object, List<String> result) {
        if (object == null || object.toString().isEmpty()) {
            return;
        }

        if (object instanceof String) {
            result.add((String) object);
        } else if (object instanceof Object[]) {
            for (Object element : (Object[]) object) {
                extractStrings(element, result);
            }
        } else {
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    extractStrings(value, result);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }
    }
}
