package Online_Shopping_Cart;

class ItemNotFoundException extends Exception{
	ItemNotFoundException(String s){
		super(s);
	}
	
}

class EmptyCartException extends Exception{
	EmptyCartException(String s){
		super(s);
	}
}
