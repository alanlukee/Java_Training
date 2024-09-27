package Online_Shopping_Cart;

public class Item {
	private String itemName;
	private double price;
	private int quantity;
	
	Item(String itemName, double price, int quantity){
		
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return ("Item name: "+itemName+" Price "+price+" Quantity: "+quantity);
		
	}

}
