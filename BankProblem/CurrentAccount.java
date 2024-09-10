package BankProblem;

public class CurrentAccount extends BankAccount {

	CurrentAccount(int accountNumber, int balance) {
		super(accountNumber, balance);
			}
	void calculateInterest() {
		System.out.println("No interest for Current Account."+balance);
	}
	

}
