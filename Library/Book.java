package Library;

public class Book extends LibraryItem {
	
	private String author;
	private int numberOfPages;
	
	Book(String  LibraryItemtitle,String LibraryItemID,String author, int numberOfPages ){
		
		super(LibraryItemtitle, LibraryItemID );
        this.author = author;
        this.numberOfPages = numberOfPages;
		
	}
	
	public void getDetails() {
		
        super.getDetails(); 
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numberOfPages);
    }
    
    
    public void getDetails(boolean includeAuthor) {
        if (includeAuthor) {
            getDetails();   
        } else {
            super.getDetails();
        }
    }

}
