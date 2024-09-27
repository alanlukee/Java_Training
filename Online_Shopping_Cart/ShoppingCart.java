package Online_Shopping_Cart;


//add items to their cart, remove items, and calculate the total cost

public  abstract class ShoppingCart {
	
	public abstract void addItem(Item item) throws ItemNotFoundException;
	public abstract void removeItem(String itemName) throws ItemNotFoundException,EmptyCartException ;
	public abstract void calculateTotalCost();
	

}
