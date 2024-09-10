package BankProblem;

public class SavingsAccount extends BankAccount {

	SavingsAccount(int accountNumber, double balance) {
		super(accountNumber, balance);

	}
	void calculateInterest() {
		double interest = balance *0.04;
		System.out.println("Interest for Savings Account: "+interest);
	}

}
