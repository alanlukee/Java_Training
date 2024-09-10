package Shape_Hierarchy;

public class Main {

	public static void main(String[] args) {
		
		try {
			Circle circle = new Circle("Blue", 3);
			Rectangle rec = new Rectangle("Green", 5, 4);
			Square sq = new Square("Red", 7);
			
			System.out.println("You have the following shapes -->");
			System.out.println(" ");
			System.out.println(circle.getColour() + " circle with, Perimeter: " + circle.calculatePerimeter() + " cm, Area: " + circle.calculateArea() + " cm^2");
			System.out.println(rec.getColour() + " rectangle with, Perimeter: " + rec.calculatePerimeter() + " cm, Area: " + rec.calculateArea() + " cm^2");
			System.out.println(sq.getColour() + " square with, Perimeter: " + sq.calculatePerimeter() + " cm, Area: " + sq.calculateArea() + " cm^2");

		} 
		catch (IllegalArgumentException e) {
			System.err.println("ayoo, " + e.getMessage());
		}
	}
}
