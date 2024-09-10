package Shape_Hierarchy;

public class Rectangle extends Shape {
	
	private double length;
	private double width;

	Rectangle(String colour,double length, double width) {
		super(colour);
		if (length ==width) {
			if (length < 0) {
				throw new IllegalArgumentException("side cannot be negative.");
			}
		}
		if (length < 0 || width < 0) {
			throw new IllegalArgumentException("length and width cannot be negative.");
		}
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		if (length < 0) {
			throw new IllegalArgumentException("length and width cannot be negative.");
		}
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		if (length < 0) {
			throw new IllegalArgumentException("length and width cannot be negative.");
		}
		this.width = width;
	}
	
	@Override
	double calculateArea() {
		
		return length *width;
	}
	@Override
	double calculatePerimeter() {
		
		return 2*(length+width);
	}

}
