package Library;

public class LibraryDemo {

	public static void main(String[] args) {
		
		Book book1 = new Book("ABC","1A","alan",2400);
		
		Magazine mag1 = new Magazine("XYZ","2A",4,"24-03-2002");
		
		
		book1.getTitle();
		book1.getId();
		
	
		book1.getDetails(true);
		System.out.println(" ");
		book1.getDetails();
		System.out.println(" ");
		mag1.getDetails();
		System.out.println(" ");
		mag1.updatePublicationDate("25-04-2002");
		
	}

}
