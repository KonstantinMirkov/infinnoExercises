package oopExamples.oopExample7;

public class Dog extends Mammal {
    private String favouriteActivity;

    public Dog(int hairCount, String name, int age, Gender gender) {
        super(hairCount, name, age, gender);
    }

    public String getFavouriteActivity() {
        return favouriteActivity;
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing " + getFavouriteActivity());
    }
}
