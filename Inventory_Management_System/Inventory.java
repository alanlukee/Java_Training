package Inventory_Management_System;


public abstract class Inventory {
	
	public abstract void addItem(Item item);
	public abstract void removeItem(String item) throws ItemNotFoundException, ItemOutOfStockException;
	public abstract void checkAvailability(String item) throws ItemNotFoundException, ItemOutOfStockException;
	

}
