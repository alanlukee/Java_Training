package Book_Library_Exception_Handling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



@SuppressWarnings("serial")
class BookNotFoundException extends Exception{
	BookNotFoundException(String s){
		super(s);
		
	}
	
}
@SuppressWarnings("serial")
class EmptyLibraryException extends Exception{
	
	EmptyLibraryException(String s){
		super(s);
		
	}
	
}

public class Main extends Library {
	
	List<Book> libraryBooks = new ArrayList<>();
	
	@Override
	public void addBook(Book b) {
		// TODO Auto-generated method stub
		libraryBooks.add(b);
		System.out.println("Book added successfully.");
	}

	@Override
	public void removeBook(String removeBook) throws BookNotFoundException, EmptyLibraryException {
	    boolean bookFound = false;
	    
	    if(libraryBooks.isEmpty()) {
	        throw new EmptyLibraryException("Library is empty");

	    	
	    }
	    for (Book book : libraryBooks) {
	    	
	    	//System.out.println(book.toString());
	    	
	        if (book.bookTitle.equals(removeBook)) {
	            bookFound = true;
	            libraryBooks.remove(book);
	            System.out.println("Book removed successfully.");
	            break;
	        }
	    }

	    if (!bookFound) {
	        throw new BookNotFoundException("Book not found.");
	    }
	}

	@Override
	public void searchBook(String searchBook) throws BookNotFoundException, EmptyLibraryException {
		boolean searchFlag = false;
		
		if(libraryBooks.isEmpty()) {
	        throw new EmptyLibraryException("Library is empty");
	    }
		
	    for (Book book : libraryBooks) {
	    	
	    	//System.out.println(book.toString());
	    	
	        if (book.bookTitle.equals(searchBook)) {
	        	searchFlag = true;
	            System.out.println("Book found.");
	            System.out.println(" ");
	            System.out.println(book.toString());
	            System.out.println(" ");
	            break;
	        }
	    }
	        
		    if (!searchFlag) {
		        throw new BookNotFoundException("Book not found.");
		    }
	    }
	
	public void displayBooks() throws EmptyLibraryException {
		if (libraryBooks.isEmpty()) {
			throw new EmptyLibraryException("Library is empty");
		}
		for(Book book : libraryBooks) {
			System.out.println(book.toString());
		}
	}
	
		
	
	public static void main(String[] args) throws BookNotFoundException, EmptyLibraryException  {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to the Library!");
		System.out.println(" ");
		System.out.println("1. Add book");
		System.out.println("2. Remove book");
		System.out.println("3. Search book");
		System.out.println("4. Display books");
		System.out.println("5. Exit");
		System.out.println(" ");
		
		Main m1 = new Main();
		
		try(Scanner scan = new Scanner(System.in)){
			
			boolean flag = true;
			int choicePick = 0;
			
			while(flag) {
				String bookTitle;
				String author;
				int ISBN;
				String removeBook;
				String searchBook;
				
				boolean validationFlag = true;
				
				while(validationFlag) {
				System.out.println("Enter your choice: ");
				
				choicePick = scan.nextInt();
				
				if(choicePick >= 1 && choicePick <= 5) {
					validationFlag = false;
				}
				else {
					validationFlag = true;
					System.out.println("Please enter 1 or 2 or 3 or 4 or 5");
					System.out.println(" ");
					scan.next();
				}
				}
				
				if(choicePick == 1) {
				   
				    System.out.println("Enter book title: ");
				    scan.nextLine(); 
				    bookTitle = scan.nextLine(); 

				    System.out.println("Enter author: ");
				    author = scan.nextLine();

				    System.out.println("Enter ISBN: ");
				    ISBN = scan.nextInt(); 

				    Book book = new Book(bookTitle, author, ISBN);
				    m1.addBook(book);
				}
				else if(choicePick == 2) {
				   
					
				    scan.nextLine();  
				    System.out.println("Enter book title: ");
				    
				    removeBook = scan.nextLine();
				  
				    
				    try {
				    m1.removeBook(removeBook);
				    }
				    catch(BookNotFoundException e){
				    	System.out.println(e.getMessage());
				    }
				    catch( EmptyLibraryException e){
				    	System.out.println(e.getMessage());
				    }
				    
				    
				}
				else if(choicePick ==3) {
					
				    scan.nextLine();  
				    System.out.println("Enter book title: ");
				    searchBook = scan.nextLine();
				    try {
				    	m1.searchBook(searchBook);
				    }
					catch(BookNotFoundException e) {
				    	System.out.println(e.getMessage());

					}
				    catch( EmptyLibraryException e){
				    	System.out.println(e.getMessage());
				    }

				}
				
				else if (choicePick==4) {
					try {
						m1.displayBooks();
					}
					catch(EmptyLibraryException e) {
						System.out.println(e.getMessage());
					}
					
				}
				else if (choicePick ==5) {
					System.exit(0);
				}
				else {
					System.out.println("Invalid choice");
				}
	
			}
		}
	
	}

}
