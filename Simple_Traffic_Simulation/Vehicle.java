package Simple_Traffic_Simulation;

public class Vehicle {
	
	private String carType;
	private int speed;
	private int position;
	
	Vehicle(String carType, int speed, int position ){
		
		this.setCarType(carType);
		this.speed = speed;
		this.position = position;
		
	}
	
	public void accerlate(int increase) { 
		this.speed = this.speed +increase;
		
	}
	
	public void decerlate(int decrease) { 
		if(this.speed - decrease>0) {
			this.speed = this.speed - decrease;
		}
		else {
			System.out.println("Cant decelate to negative speed.");
		}
		
	}
	
	public void move() {
		
		this.position = this.position + 5;
		
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	

}
