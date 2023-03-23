package oopExamples.oopExample7;

public class Mammal extends Animal implements Pet {
    private int hairCount;

    public Mammal(int hairCount, String name, int age, Gender gender) {
        super(name, age, gender);
        this.hairCount = hairCount;
    }

    public int getHairCount() {
        return hairCount;
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing");
    }

    @Override
    public void petInfo() {
        System.out.println("The pet name is " + getName() + "and its gender is " + getGender());
    }
}
