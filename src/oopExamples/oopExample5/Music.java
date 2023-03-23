package oopExamples.oopExample5;

import java.util.ArrayList;

public class Music {
    public void tune(Instrument instrument) {
        instrument.play();
    }

    public void tuneAll(ArrayList<Instrument> instruments) {
        instruments.forEach(this::tune);
    }

    public static void main(String[] args) {
        ArrayList<Instrument> instruments = new ArrayList<>();
        Stringed stringed = new Stringed();;
        instruments.add(stringed);
        Wind wind = new Wind();
        instruments.add(wind);
        Woodwind woodwind = new Woodwind();
        instruments.add(woodwind);
    }
}
