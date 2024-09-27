package Simple_Traffic_Simulation;

public class TrafficLight {
	
	private static String color;
	
	
	TrafficLight(String color){
		
		this.color = color;
		
	}
	
	
	
	public void changeColor() {
		if(color.equals("green")) {
			color = "yellow";
		}
		else if(color.equals("yellow")) {
			color = "red";
		}
		else if(color.equals("red")) {
			color = "green";
		}
	}
	
	

	public static String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	

}
