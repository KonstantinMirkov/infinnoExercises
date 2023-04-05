package fileLockingExamples.fileLockingExample1;

import static fileLockingExamples.fileLockingExample1.Main.writeFileWithLock;

public class FileWriteThread extends Thread {
    private String filename;
    private String content;

    public FileWriteThread(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void run() {
        writeFileWithLock(filename, content, getName());
    }
}
