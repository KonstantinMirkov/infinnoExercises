package tests.test8;

public class Task1 {
    public static void main(String[] args) {
        Employee[] originalArray = {new Employee("Gosho", 22),
                new Manager("Petar", 35, 25),
                new Intern("Mladen", 18, "schoolName")};

        Employee[] clonedArray = cloneArray(originalArray);

        System.out.println("Original array: ");
        for (Employee employee : originalArray) {
            System.out.println(employee);
        }

        System.out.println("Cloned array: ");
        for (Employee employee : clonedArray) {
            System.out.println(employee);
        }
    }

    public static <T> T[] cloneArray(T[] originalArray) {
        Employee[] newArray = new Employee[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = (Employee) originalArray[i];
        }

        return (T[]) newArray;
    }

    public static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Employee() {

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
                   "name - '" + name + '\'' +
                   ", age - " + age +
                   '}';
        }
    }

    public static class Manager extends Employee {
        private int bonus;

        public Manager(String name, int age, int bonus) {
            super(name, age);
            this.bonus = bonus;
        }

        public Manager() {

        }

        public int getBonus() {
            return bonus;
        }

        @Override
        public String toString() {
            return "Manager{" +
                   "name - '" + getName() + '\'' +
                   ", age - " + getAge() +
                   ", bonus - " + bonus +
                   '}';
        }
    }

    public static class Intern extends Employee {
        private String school;

        public Intern(String name, int age, String school) {
            super(name, age);
            this.school = school;
        }

        public Intern() {

        }

        public String getSchool() {
            return school;
        }

        @Override
        public String toString() {
            return "Intern{" +
                   "name - '" + getName() + '\'' +
                   ", age - " + getAge() +
                   ", school - '" + school + '\'' +
                   '}';
        }
    }
}
