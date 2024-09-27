package Online_Bookstore;

import java.util.ArrayList;
import java.util.List;

public class Store {
	
	static List<Book> storeBooks = new ArrayList<>();
	
	public void addBookToStore(Book book) {
		
		boolean bookInStore = false;
		
		for(Book i :storeBooks) {
			if(i.getISBN().equals(book.getISBN())) {
				bookInStore = true;
				i.setStock(i.getStock()+book.getStock());
				System.out.println("Stock updated for "+i.getBookTitle());
				break;
			}
		}
		
		if(bookInStore==false) {
			storeBooks.add(book);
			System.out.println("Added "+book.getBookTitle()+" to store");
		}
			
	}
	
	public static Book searchInStore(String bookTitle) throws EmptyStoreException, BookNotFoundException {
		boolean bookInStore = false;
		
		Book foundBook= null;
		
		if(storeBooks.isEmpty()) {
			throw new EmptyStoreException("Store is empty");
		}
		
		for(Book i : storeBooks) {
			if(i.getBookTitle().equals(bookTitle)) {
				bookInStore = true;
				System.out.println("Book found in store.");
				foundBook = i;
				System.out.println(i.toString());
				System.out.println(" ");
				break;
				
			}
		}
		if(bookInStore==false) {
			throw new BookNotFoundException("Book not found.");
		}
		return foundBook;
		
	}
	


}
