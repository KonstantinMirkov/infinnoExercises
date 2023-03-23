package oopExamples.oopExample3;

public class Main {
    public static void main(String[] args) {
        VehiclesManager vehiclesManager = new VehiclesManager();
        vehiclesManager.addVehicle(new Car("bmw", "AM4", 2, 2000, 4));
        vehiclesManager.addVehicle(new Car("Mercedes", "ASM4", 2, 2000, 4));
        vehiclesManager.addVehicle(new Truck("Mercedes", "ASM4", 2, 2000, 4, 100));
        vehiclesManager.addVehicle(new Motorcycle("Suzuki", "ASM4", 2, 1000, 4, 10));

        System.out.println();

    }
}
