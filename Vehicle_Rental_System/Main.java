package Vehicle_Rental_System;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       
        Car car = new Car();
        
        car.vehicleId = "CAR001";
        car.brand = "Toyota";
        car.model = "Camry";
        car.baseRent = 50; 
        car.hasAirConditioner = true;

        
        Bike bike = new Bike();
        
        bike.vehicleId = "BIKE001";
        bike.brand = "Honda";
        bike.model = "CBR";
        bike.baseRent = 20; 
        bike.engineCapacity = 200; 

        
        Truck truck = new Truck();
        
        truck.vehicleId = "TRUCK001";
        truck.brand = "Ford";
        truck.model = "F-150";
        truck.baseRent = 100; 
        truck.loadCapacity = 8; 

        ElectricScooter es = new ElectricScooter();
        
        es.scooterId = "SCOOT001";
        es.brand = "Xiaomi";
        es.batteryCapacity = 25; 
        es.baseRent = 15; 

       
        List<Rentable> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);
        vehicles.add(es);

        
        for (Rentable vehicle : vehicles) {
        	
            vehicle.displayDetails();
            System.out.println("Rent: " + vehicle.calculateRent(3));
            System.out.println(" ");
        }
    }
}
