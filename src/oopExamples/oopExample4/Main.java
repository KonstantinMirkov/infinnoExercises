package oopExamples.oopExample4;

public class Main {
    public static void main(String[] args) {
        invokeButtonListener(new Button());
        invokeButtonListener(new Checkbox());
    }

    public static void invokeButtonListener(ClickListener clickListener) {
        clickListener.onClick();

    }
}
