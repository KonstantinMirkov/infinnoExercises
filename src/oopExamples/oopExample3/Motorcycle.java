package oopExamples.oopExample3;

public class Motorcycle extends Vehicle {
    private int engineSize;

    public Motorcycle(String maker, String model, int age, int weigh, int engineSize, int i) {
        super(maker, model, age, weigh);
        super.setMaker(getMaker());
        super.setModel(getModel());
        super.setAge(getAge());
        super.setWeigh(getWeigh());
        this.engineSize = engineSize;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
}
