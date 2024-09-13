package ATM_Exception_Handling;

public abstract class ATM  {
	
//    double balance;
//    
//    	ATM(double balance){
//    		this.balance = balance;
//    	}

    public abstract double deposit(double amount) throws InvalidAmountException;

    public abstract double withdraw(double amount) throws InsufficientFundsException, InvalidAmountException;
}

