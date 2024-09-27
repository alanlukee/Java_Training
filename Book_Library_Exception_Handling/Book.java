package Book_Library_Exception_Handling;


public class Book {
	
	String bookTitle;
	String author;
	int ISBN;
	
	Book(String bookTitle, String author, int ISBN){
		
		this.bookTitle = bookTitle;
		this.author = author;
		this.ISBN = ISBN;
		
	}
	
    @Override
    public String toString() {
        return "Title: " + bookTitle + ", Author: " + author + ", ISBN: " + ISBN;
    }
}
