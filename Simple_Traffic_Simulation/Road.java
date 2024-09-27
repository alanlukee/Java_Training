package Simple_Traffic_Simulation;

import java.util.ArrayList;
import java.util.List;

public class Road {
	
	private int length;
	
	List<Vehicle> vehicleList = new ArrayList<>();
	List<TrafficLight> trafficLights = new ArrayList<>();
	

	public Road(int length) {
		
		this.length = length;
        this.vehicleList = new ArrayList<>();
        this.trafficLights = new ArrayList<>();
		// TODO Auto-generated constructor stub
		
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public void addVehicle(Vehicle v) {
		
		vehicleList.add(v);
		
	}
	
	public void removeVehicle(Vehicle v) {
		
		vehicleList.remove(v);
		
	}
	public void updateTraffic() {
		
		for (TrafficLight trafficLight : trafficLights) {
        	
            trafficLight.changeColor();
            System.out.println("Traffic light is now " + trafficLight.getColor());
        }
		
		
		for(Vehicle vehicle:vehicleList ) {
			if(TrafficLight.getColor().equals("green"))
				vehicle.move();
			
			if(vehicle.getPosition()>length) {
				System.out.println("Vehicle out of the road.");
			}
			else {
				System.out.println("Vehicle position: "+vehicle.getPosition());
			}
			
		}
		
        
		
	}
	
	public void addTrafficLight(TrafficLight tl) {
		
		trafficLights.add(tl);
		
	}
	
	
	

}
