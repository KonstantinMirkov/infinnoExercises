package oopExamples.oopExample6;

public class AutoFilesSaver implements  AutoSave, FileSaver {
    @Override
    public void setAutoIntervalSave(int interval) {
        System.out.println("the interval is " + interval);
    }

    @Override
    public void saveName(String filename) {
        System.out.println("the filename is " + filename);
    }
}
