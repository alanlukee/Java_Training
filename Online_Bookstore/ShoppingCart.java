package Online_Bookstore;

import java.util.ArrayList;
import java.util.List;

//search for books, add books to their cart, and place orders.

public class ShoppingCart {
	
	List<Book> cart = new ArrayList<>();
	
	
	public void addToCart(String bookTitle, int count) throws OutOfStockException {
		boolean foundBook = false;
		
		//if book is already there in cart
		
		for(Book i : cart) {
			if(i.getBookTitle().equals(bookTitle)) {
				foundBook = true;
				try {
				i.bookStockDecrement(i, count);
				
				System.out.println("Book added to cart");
				System.out.println(i.toString());
				}
				catch(OutOfStockException e) {
					System.out.println(e.getMessage());
				}

				break;
				
			}
		}
		if(foundBook ==false) {
			Book toaddBook = null;
		
				try {
					toaddBook = Store.searchInStore(bookTitle);
				} catch (EmptyStoreException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());;
				} catch (BookNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());;

				}
				
			
			cart.add(toaddBook);
			try {
			toaddBook.bookStockDecrement(toaddBook, count);
			}
			catch(OutOfStockException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Book added to cart");
			System.out.println(toaddBook.toString());
		}
		
		
	}
	
	public void placeOrder(String address) throws InvalidAddressException, EmptyCartException {
		
		if(cart.isEmpty()) {
			throw new EmptyCartException("Cart is empty. Cannot place order");
		}
		
		if (validateAddress(address)==true) {
			System.out.println("Order placed successfully");
			cart.clear();
			System.out.println("Cart is now empty");
		}
		else {
			throw new InvalidAddressException("Invalid address");
		}
		
	}
	
	public boolean validateAddress(String address) {
		
		if (address ==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public void displayCart() throws EmptyCartException {
		if(cart.isEmpty()) {
			throw new EmptyCartException("Cart is empty");
		}
		for (Book i: cart) {
			System.out.println("Title: "+i.getBookTitle()+" Quantity: "+i.getQuantity());
		}
	}
	

}
