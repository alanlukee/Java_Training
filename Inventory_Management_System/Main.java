package Inventory_Management_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ItemNotFoundException extends Exception {
	ItemNotFoundException(String s){
		super(s);
	}
}
	
class ItemOutOfStockException extends Exception{
	
	ItemOutOfStockException(String s) {
		super(s);
	}
	
}


public class Main extends Inventory {
	
	List<Item> itemlist = new ArrayList<>();

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		
		boolean itemFound = false;
		
		for( Item i : itemlist) {
			if(i.itemName.equals(item.itemName)) {
				i.quantity = i.quantity +item.quantity;
				itemFound = true;
				break;
			}
		}
		if(itemFound==false) {
			itemlist.add(item);
			System.out.println("Item added successfully.");	
		}

	}
	@Override
	public void removeItem(String item) throws ItemNotFoundException, ItemOutOfStockException {
		// TODO Auto-generated method stub
		
		boolean found = true;
		
		if(itemlist.isEmpty()) {
			throw new ItemNotFoundException("Item not found.");
		}
		else {
			for(Item i :itemlist ) {
				
				if(i.quantity ==0) {
					throw new ItemOutOfStockException("Item is out of stock.");
				}
				
				
				if(i.itemName.equals(item)) {
					found = false;
					i.quantity = i.quantity - 1;
					
					if(i.quantity==0) {
						
						System.out.println("The item is now out of stock");
						itemlist.remove(i);
					}
					
					System.out.println("Item removed successfully.");
					System.out.println(i.toString());
					break;
				}
				
			}
			
			if(found) {
				throw new ItemNotFoundException("Item not found.");
			}
		}
		
	}

	@Override
	public void checkAvailability(String item) throws ItemOutOfStockException, ItemNotFoundException {
		// TODO Auto-generated method stub
		
		if(itemlist.isEmpty()) {
			throw new ItemNotFoundException("Item not found.");
		}
		for(Item i : itemlist) {
			if(i.itemName.equals(item)) {
				if(i.quantity>0) {
					System.out.println("Item is available");
					System.out.println(i.toString());
					break;
				}
				
			}
			else {
				throw new ItemOutOfStockException("Item not found.");
			}
		}
			
		
	}
	


	public static void main(String[] args) throws ItemNotFoundException, ItemOutOfStockException   {
		// TODO Auto-generated method stub
		
		
		System.out.println("Welcome to the inventory management system!");
		System.out.println(" ");
		
		System.out.println("1. Add item");
		System.out.println("2. Remove item");
		System.out.println("3. Check item availability");
		System.out.println("4. Exit");
		System.out.println(" ");
		
		Main m1 = new Main();
		
		boolean flag = true;
		try(Scanner scan = new Scanner(System.in)){
			
			while(flag) {
				
				String itemName;
				int quantity;
				double price;
				int choicePick = 0;
				String removeItem;
				String checkAvail;
				
				boolean validationFlag = true;
				
				while(validationFlag) {
					
					System.out.println("Enter your choice: ");
					choicePick = scan.nextInt();
				
					if(choicePick>=1 && choicePick<=4) {
					validationFlag = false;
					}
					else {
						validationFlag = true;
						System.out.println("Please enter 1/2/3/4");
						scan.next();
					}
					
				}
				
				if (choicePick ==1) {
					//adding item
					scan.nextLine();
					System.out.println("Enter item name: ");
					itemName = scan.nextLine();
					System.out.println("Enter quantity: ");
					quantity = scan.nextInt();
					System.out.println("Enter price: ");
					price = scan.nextDouble();
					Item item = new Item(itemName,quantity, price);
					m1.addItem(item);
					
					
				}
				
				else if(choicePick ==2) {
					
					//removing item
					
					scan.nextLine();
					System.out.println("Enter item name: ");
					removeItem = scan.nextLine();
					try {
						m1.removeItem(removeItem);
					}
					catch(ItemNotFoundException e) {
						System.out.println(e.getMessage());
					}
					catch(ItemOutOfStockException e) {
						System.out.println(e.getMessage());
					}
				
				}
				
				else if(choicePick ==3) {
					
					//item avail check
					scan.nextLine();
					System.out.println("Enter item name: ");
					checkAvail = scan.nextLine();
					try {
						m1.checkAvailability(checkAvail);
					}
					catch(ItemNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					catch(ItemOutOfStockException e) {
						System.out.println(e.getMessage());
					}
					
					
					
					
				}
				else if(choicePick ==4) {
					
					//exit
					
					System.exit(0);
					
				}
				else {
					System.out.println("Invalid choice");
				}
				
				
			}
				
			}	
			
		}


	}



