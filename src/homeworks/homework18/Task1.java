package homeworks.homework18;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Task1 {
    public static void main(String[] args) throws Exception {
        String[] data = {
                "name,age",
                "Ivan,12",
                "Dragan,15",
                "Albena,25"
        };

        Object[] employees = createObjectArray(Employee.getClassPath(), data);

        for (Object employee: employees) {
            System.out.println(employee.toString());
        }
    }

    public static Object[] createObjectArray(String className, String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = Class.forName(className);

        String[] fieldNames = data[0].split(",");

        Object[] objects = new Object[data.length - 1];

        for (int i = 1; i < data.length; i++) {
            String[] fieldValues = data[i].split(",");

            Object obj = clazz.getDeclaredConstructor().newInstance();

            for (int j = 0; j < fieldNames.length; j++) {
                String fieldName = fieldNames[j];
                String fieldValue = fieldValues[j];
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                if (field.getType() == int.class) {
                    field.setInt(obj, Integer.parseInt(fieldValue));
                } else if (field.getType() == double.class) {
                    field.setDouble(obj, Double.parseDouble(fieldValue));
                } else if (field.getType() == boolean.class) {
                    field.setBoolean(obj, Boolean.parseBoolean(fieldValue));
                } else {
                    field.set(obj, fieldValue);
                }
            }
            objects[i - 1] = obj;
        }

        return objects;
    }

    public static class Employee {
        public String name;
        public int age;

        public Employee() {
            this.name = "";
            this.age = 0;
        }

        public static String getClassPath() {
            return Employee.class.getSimpleName();
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
