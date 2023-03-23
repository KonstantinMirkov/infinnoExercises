package oopExamples.oopExample7;

public class Bird extends Animal {
    private double wingSpan;

    public Bird(double wingSpan, String name, int age, Gender gender) {
        super(name, age, gender);
        this.wingSpan = wingSpan;
    }

    public double getWingSpan() {
        return wingSpan;
    }
}
