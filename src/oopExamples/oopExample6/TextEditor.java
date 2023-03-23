package oopExamples.oopExample6;

public class TextEditor {
    AutoFilesSaver autoFilesSaver;

    public TextEditor() {
        this.autoFilesSaver = getAutoFilesSaver();
        this.autoFilesSaver.setAutoIntervalSave(300);
    }

    void saveTextToFile(String text, String filename) {
        autoFilesSaver.saveName(filename);
    }

    public AutoFilesSaver getAutoFilesSaver() {
        return autoFilesSaver;
    }

    public void setAutoFilesSaver(AutoFilesSaver autoFilesSaver) {
        this.autoFilesSaver = autoFilesSaver;
    }
}
