package Online_Bookstore;

class BookNotFoundException extends Exception{
	
	BookNotFoundException(String s){
		super(s);
	}
}

@SuppressWarnings("serial")
class OutOfStockException extends Exception {
	
	OutOfStockException(String s){
		super(s);
	}
}

@SuppressWarnings("serial")
class EmptyCartException extends Exception{
	
	EmptyCartException(String s){
		super(s);
	}
	
}

@SuppressWarnings("serial")
class EmptyStoreException extends Exception{
	
	EmptyStoreException(String s){
		super(s);
	}
	
}

@SuppressWarnings("serial")
class InvalidAddressException extends Exception{
	InvalidAddressException(String s){
		super(s);
	}
	
}