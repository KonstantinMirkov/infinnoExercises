package oopExamples.oopExample3;

public class Car extends Vehicle {
    public int numberOfDoors;

    public Car(String maker, String model, int age, int weigh, int numberOfDoors) {
        super(maker, model, age, weigh);
        super.setMaker(getMaker());
        super.setModel(getModel());
        super.setAge(getAge());
        super.setWeigh(getWeigh());
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
