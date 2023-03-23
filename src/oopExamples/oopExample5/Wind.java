package oopExamples.oopExample5;

public class Wind implements Instrument, Type {
    @Override
    public void play() {
        System.out.println("Wind.play");
    }

    @Override
    public void adjust() {
        System.out.println("Wind.adjust");
    }

    @Override
    public void showType() {
        System.out.println("The type is wind.");
    }
}
