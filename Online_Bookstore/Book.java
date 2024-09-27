package Online_Bookstore;

public class Book {
	
	private String bookTitle;
	private String author;
	private String ISBN;
	private double price;
	private int stock;
	private int quantity;
	
	Book(String bookTitle,String author,String ISBN, double price, int stock ){
		
		this.bookTitle = bookTitle;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
		this.stock  = stock;
		this.setQuantity(0);

	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return("Title: "+bookTitle+" Author: "+author+" ISBN: "+ISBN+" Price: "+price+" Stock: "+stock);
	}
	
	public void bookStockDecrement(Book book,int count)throws OutOfStockException {
		
		if(book.getStock()>0) {
			if(count>book.getStock()) {
				throw new OutOfStockException("There are only "+book.getStock()+" books");
			}
			else {
				book.setStock(book.getStock() - count);
				book.setQuantity(book.getQuantity()+count);
				if(book.getStock()==0) {
					throw new OutOfStockException("Book is now out of stock");
					
				}
			}
		}
		else {
			throw new OutOfStockException("Book out of stock");
		}
		
	}



}
