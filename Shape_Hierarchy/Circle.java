package Shape_Hierarchy;

public class Circle extends Shape{
	
	private double radius ;
	
	Circle(String colour,double radius) {
		super(colour);
		if (radius < 0 ) {
			throw new IllegalArgumentException("radius cannot be negative.");
		}
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		if (radius < 0 ) {
			throw new IllegalArgumentException("radius cannot be negative.");
		}
		this.radius = radius;
	}
	
	@Override
	double calculateArea() {
		
		return 3.14*radius*radius;
	}
	@Override
	double calculatePerimeter() {
		
		return 2*3.14*radius;
		
	}
}
