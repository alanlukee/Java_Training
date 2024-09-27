package Book_Library_Exception_Handling;

public abstract class Library {
	
	public abstract void addBook(Book b);
	public abstract void removeBook(String removeBook) throws BookNotFoundException, EmptyLibraryException;
	public abstract void searchBook(String searchBook) throws BookNotFoundException, EmptyLibraryException;

}
