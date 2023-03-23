package oopExamples.oopExample3;

public class Truck extends Vehicle {
    private int cargoCapacity;

    public Truck(String maker, String model, int age, int weigh, int cargoCapacity, int i) {
        super(maker, model, age, weigh);
        super.setMaker(getMaker());
        super.setModel(getModel());
        super.setAge(getAge());
        super.setWeigh(getWeigh());
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}
