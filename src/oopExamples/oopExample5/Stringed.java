package oopExamples.oopExample5;

public class Stringed implements Instrument, Type {
    @Override
    public void play() {
        System.out.println("Stringed.play");
    }

    @Override
    public void adjust() {
        System.out.println("Stringed.adjust");
    }

    @Override
    public void showType() {
        System.out.println("The type is stringed.");
    }
}
