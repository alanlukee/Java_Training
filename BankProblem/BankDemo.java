package BankProblem;

public class BankDemo {

	public static void main(String[] args) {
		
		CurrentAccount acc1 = new CurrentAccount(1, 2000);
		SavingsAccount acc2 = new SavingsAccount(2, 25000);
		
		System.out.println("Current Account");
		System.out.println(acc1.accountNumber);
		System.out.println(acc1.balance);
		
		System.out.println("Savings Account");
		System.out.println(acc2.accountNumber);
		System.out.println(acc2.balance);
		
		acc2.calculateInterest();
		acc1.calculateInterest();
		acc1.deposit(3);
		

	}

}
