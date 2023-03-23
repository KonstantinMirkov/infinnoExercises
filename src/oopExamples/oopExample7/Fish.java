package oopExamples.oopExample7;

public class Fish extends Animal {
    private String waterType;
    public Fish(String waterType, String name, int age, Gender gender) {
        super(name, age, gender);
        this.waterType = waterType;
    }

    public String getWaterType() {
        return waterType;
    }
}
