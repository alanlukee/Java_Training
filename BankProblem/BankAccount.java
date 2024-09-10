package BankProblem;

public abstract class BankAccount {
	
	protected int accountNumber;
	protected double balance;
	
	BankAccount(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	abstract void calculateInterest();
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("amount now is "+balance);
		
	}
	
	public void withdraw(double amount) {
		if(balance>amount && balance >0) {
			balance = balance - amount;
			System.out.println("New balance: "+balance);
		}
		else {
			System.out.println("insufficient funds");
		}
			
	}
	

}
