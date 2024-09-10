package Shape_Hierarchy;

public abstract class Shape {
	
	private String colour;
	
	Shape(String colour){
		this.colour = colour;	
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	abstract double calculateArea();
	abstract double calculatePerimeter();

}
