package Inventory_Management_System;

public class Item {
	
	
	String itemName;
	int quantity;
	double price;
	
	Item(String itemName, int quantity, double price ){
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String toString() {
		return ("ItemName: " +itemName+ " quantity: " +quantity+ " price: " +price);
		
	}
	


}
