package oopExamples.oopExample8;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Bob", 5, "meow");
        animal.createCat("Tom", 3 , "meow", 7);
        animal.getInfo();
    }
}
