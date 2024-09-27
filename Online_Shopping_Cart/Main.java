package Online_Shopping_Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends ShoppingCart {
	
	
	List<Item> cart = new ArrayList<>();
	
	@Override
	public void addItem(Item item) throws ItemNotFoundException {
		// TODO Auto-generated method stub
		
		boolean itemFound = false;
		
		for(Item i : cart) {
			if(i.getItemName().equals(item.getItemName())) {
				itemFound = true;
				i.setQuantity(i.getQuantity()+item.getQuantity());
				System.out.println("Item quantity updated successfully.");
				System.out.println(i);
				break;
			}
			
		}
		if(itemFound ==false) {
			cart.add(item);
			System.out.println("Item added successfully.");	
			System.out.println(item);
		}
	
	}

	@Override
	public void removeItem(String itemName) throws EmptyCartException, ItemNotFoundException {
		// TODO Auto-generated method stub
		
		boolean found = false;
		
		if(cart.isEmpty()) {
			throw new EmptyCartException("Cart is empty");
		}
		else {
			for(Item i : cart) {
				if(i.getItemName().equals(itemName)) {
					found = true;
					i.setQuantity(i.getQuantity() - 1);
					
					if(i.getQuantity()==0) {
						System.out.println("Item is now out of stock");
						cart.remove(i);
					}
					System.out.println("Item removed successfully.");
					System.out.println(i.toString());
					break;
				}
			
			}
			if(found==false) {
				throw new ItemNotFoundException("Item not found");
			}
			
		}
		
	}

	@Override
	public void calculateTotalCost() {
		// TODO Auto-generated method stub
		double totalCost=0;
		for(Item i : cart) {
			totalCost = totalCost + (i.getPrice()*i.getQuantity());
		}
		System.out.println("Total cost: "+totalCost);
		
	}
	
	
	public static void main(String[] args) throws ItemNotFoundException, EmptyCartException {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to the online store!");
		System.out.println(" ");
		System.out.println("1. Add item");
		System.out.println("2. Remove item");
		System.out.println("3. Calculate total");
		System.out.println("4. Exit");
		System.out.println(" ");
		
		Main m1 = new Main();
		
		
		try(Scanner scan = new Scanner(System.in)) {
			int choicePick = 0;
			while(true) {
				String itemName;
				double price;
				int quantity;
				String removeItem;
				
				boolean validationFlag = true;
				while(validationFlag) {
					System.out.println("Enter your choice: ");
					choicePick = scan.nextInt();
					if(choicePick >=1 && choicePick<=4) {
						validationFlag = false;
					}
					else {
						System.out.println("Please enter 1/2/3/4");
					}
				}
				
				if(choicePick ==1) {
					//add item
					scan.nextLine();
					System.out.println("Enter item name: ");
					itemName = scan.nextLine();
					System.out.println("Enter price: ");
					price = scan.nextDouble();
					scan.nextLine();
					System.out.println("Enter quantity:");
					quantity = scan.nextInt();
					
					Item item = new Item(itemName, price, quantity);
					try {
						m1.addItem(item);
					}
					catch(ItemNotFoundException e) {
						System.out.println(e.getMessage());
						
					}	
				}
				else if(choicePick ==2) {
					
					//remove item
					scan.nextLine();
					System.out.println("Enter item name: ");
					removeItem = scan.nextLine();
					try {
					m1.removeItem(removeItem);
					}
					catch(ItemNotFoundException e) {
						System.out.println(e.getMessage());
					}
					catch(EmptyCartException e) {
						System.out.println(e.getMessage());
					}
					
					
				}
				else if(choicePick ==3) {
					
					//calculate total
					m1.calculateTotalCost();

				}
				else if(choicePick ==4) {
					System.exit(0);
				}
				else {
					System.out.println("Invalid choice");
				}
				
				
				
				
			}
			
		}

	}

	

}
