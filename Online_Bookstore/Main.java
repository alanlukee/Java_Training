package Online_Bookstore;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws OutOfStockException {
		// TODO Auto-generated method stub
		
		Store store = new Store();
		
		System.out.println("Welcome to the online bookstore!");
		System.out.println(" ");
		
		Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 10.99, 7);
		Book b2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 13.99, 6);
		Book b3 = new Book("Pride and Prejudice", "Jane Austen", "9781503290563", 9.99, 5);

		store.addBookToStore(b1);
		store.addBookToStore(b2);
		store.addBookToStore(b3);

		ShoppingCart cart = new ShoppingCart();

		try (Scanner scan = new Scanner(System.in)) {
			int choicePick = 0;
			
			
			System.out.println(" ");
			System.out.println("1. Search for a book");
			System.out.println("2. Add book to cart");
			System.out.println("3. Place order");
			System.out.println("4. Display Cart");
			System.out.println("5. Exit");
			System.out.println(" ");
			
			while(true) {
				String searchBook;
				String cartBook;
				int bookCount;
				String address;
				
				boolean validationflag = true;
				
				while(validationflag) {
					System.out.println("Enter your choice:");
					choicePick = scan.nextInt();
					scan.nextLine();
					if(choicePick>=1 && choicePick <=5) {
						validationflag = false;
					}
					
					else {
						System.out.println("Please enter 1/2/3/4/5");
						
					}
				}
				
				
				if(choicePick ==1) {
					//to search for book
					
					System.out.println("Enter book title: ");
					searchBook = scan.nextLine();
					try {
						Store.searchInStore(searchBook);
					} 
					catch (EmptyStoreException e){
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					catch( BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					
					
				}
				else if(choicePick ==2) {
					//adding book to cart
					
					System.out.println("Enter book title: ");
					cartBook = scan.nextLine();
					System.out.println("How many books to be added to cart?");
					bookCount = scan.nextInt();
					scan.nextLine();
					cart.addToCart(cartBook, bookCount);
					
				}
				else if(choicePick ==3) {
					//placing order
					
					System.out.println("Enter shipping address: ");
					address = scan.nextLine();
					try {
						cart.placeOrder(address);
					} catch (InvalidAddressException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					} catch (EmptyCartException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}	
				}
				else if(choicePick ==4) {
					
					try {
						cart.displayCart();
					} catch (EmptyCartException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				else if(choicePick ==5) {
					System.out.println("Thank you, Visit again!");
					System.exit(0);
				}
				else {
					System.out.println("Invalid choice.");
				}
				
			}
		}
		
	}

}
