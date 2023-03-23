package oopExamples.oopExample5;

public class Woodwind extends Wind {
    @Override
    public void play() {
        System.out.println("Woodwind.play");
    }

    @Override
    public void showType() {
        System.out.println("the Type is woodwind.");
    }
}
