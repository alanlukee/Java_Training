package ATM_Exception_Handling;

public class Account extends ATM {

    String accountNumber;
    String accountName;
    double balance;

    Account(String accountNumber, String accountName, double balance) {
    	//super(balance);
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance; 
    }

    @Override
    public double deposit(double amount) throws InvalidAmountException {
    	if (amount<=0) {
    		throw new InvalidAmountException("Amount cannot be negative or zero");
    		
    	}
        balance = balance + amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
    	
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        if(amount<=0) {
    		throw new InvalidAmountException("Amount cannot be negative or zero");

        }
        balance = balance - amount;
        return balance;
    }
}
