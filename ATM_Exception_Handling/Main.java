package ATM_Exception_Handling;

import java.util.InputMismatchException;
import java.util.Scanner;

class InsufficientFundsException extends Exception {
	
	InsufficientFundsException(String s){
		super(s);
	}
}

class InvalidAmountException extends Exception {
	
	InvalidAmountException(String s){
		super(s);
	}
}

public class Main {

	public static void main(String[] args) throws InvalidAmountException,InputMismatchException  {
		// TODO Auto-generated method stub
		
		Account acc = new Account("ES102", "XYZ", 50000);
		
		
//		System.out.println("current balance  " +acc.balance);
//		acc.deposit(10000);
//		System.out.println("updated balance  " +acc.balance);

		
		System.out.println("Welcome to the ATM!");
		System.out.println(" ");
		System.out.println("1. Check Balance");
		System.out.println("2. Withdraw");
		System.out.println("3. Deposit");
		System.out.println("4. Exit");
		System.out.println(" ");
		
		
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		int choicePick = 0;
		
		while (flag) {
			
			boolean validationFlag = true;
			while(validationFlag) {
			System.out.println("Enter your choice: ");
			
			choicePick = scan.nextInt();
			
			if(choicePick >= 1 && choicePick <= 4) {
				validationFlag = false;
			}
			else {
				validationFlag = true;
				System.out.println("Please enter 1 or 2 or 3 or 4");
				System.out.println(" ");
				//scan.next();
			}
			}
			if (choicePick == 1) {

				System.out.println("Your balance is " + acc.balance);

			} else if (choicePick == 2) {

				System.out.println("Enter withdrawal amount: ");

				double withdrawAmount = scan.nextDouble();

				try {
					acc.withdraw(withdrawAmount);
					System.out.println("Withdrawal successful. Your new balance is " + acc.balance + ".");

				} catch (InsufficientFundsException e) {
					
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				catch(InvalidAmountException e) {
					System.out.println(e.getMessage());
				}

			} else if (choicePick == 3) {
				
				System.out.println("Enter deposit amount: ");
				double depositAmount = scan.nextDouble();
				try {
					acc.deposit(depositAmount);
					System.out.println("Amount deposited to your account");
				}
				catch(InvalidAmountException e) {
					System.out.println(e.getMessage());
				}
				
			} else if (choicePick == 4) {
				System.out.println("Bye");
				
				System.exit(0);

			} else {
				System.out.println("Invalid choice");
			} 
		}
		

	}

}
