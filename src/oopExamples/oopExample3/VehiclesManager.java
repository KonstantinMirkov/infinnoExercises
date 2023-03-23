package oopExamples.oopExample3;

import java.util.ArrayList;
import java.util.List;

public class VehiclesManager {
    List<Vehicle> vehicleList = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
       this.vehicleList.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicleList.remove(vehicle);
    }
}
