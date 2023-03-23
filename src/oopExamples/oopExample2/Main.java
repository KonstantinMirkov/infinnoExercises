package oopExamples.oopExample2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        car1.setBrand("Mercedes");
        car2.setBrand("Bmw");
        Car[] cars = {car1, car2};

        char letter = 'M';

        Car[] result = filterCars(cars, letter);

        for (Car car : result) {
            System.out.println(car.getBrand());
        }

    }

    private static Car[] filterCars(Car[] cars, char letter) {
        List<Car> filteredCarList = new ArrayList<>();

        for (Car car : cars) {
            if (car.getBrand().charAt(0) == letter) {
                filteredCarList.add(car);
            }
        }
        Car[] result = new Car[filteredCarList.size()];

        return filteredCarList.toArray(result);
    }
}
