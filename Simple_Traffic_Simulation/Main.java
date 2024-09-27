package Simple_Traffic_Simulation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Road road = new Road(100);
		
	      
        Vehicle car = new Vehicle("Car", 10,20);
        Vehicle truck = new Vehicle("Truck",30, 5);
        Vehicle motorcycle = new Vehicle("Motorcycle", 15,45);
        
        road.addVehicle(car);
        road.addVehicle(truck);
        road.addVehicle(motorcycle);
        
        TrafficLight trafficLight = new TrafficLight("red");
        
        road.addTrafficLight(trafficLight);
        
        

        for (int i = 0; i < 12; i++) {
            System.out.println("try " + (i + 1) + ":");
            road.updateTraffic();
            System.out.println(" ");
        }
        
        
       
	}

}
