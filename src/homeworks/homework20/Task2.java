package homeworks.homework20;

public class Task2 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            printStackTrace(e);
        }
    }

    public static void method1() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            throw new Exception("Exception in method1: ", e);
        }
    }

    public static void method2() throws Exception {
        throw new Exception("Exception in method2");
    }

    public static void printStackTrace(Exception e) {
        e.printStackTrace();
        Throwable cause = e.getCause();
        while (cause != null) {
            cause.printStackTrace();
            cause = cause.getCause();
        }
    }
}