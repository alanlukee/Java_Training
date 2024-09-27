package Simple_Video_Game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to online video game");
		System.out.println(" ");
		System.out.println("Enter your tag name: ");
		String playerName = scan.nextLine();
		
		System.out.println(" ");
		
		
	
		                               //health, attack, defense
		Player p1 = new Player(playerName, 100, 50, 30);
		Enemy e1 = new Enemy("Thanos", 75, 40, 35);
		
		System.out.println(playerName+"!, you are fighting against Thanos!");
		System.out.println(" ");
		while(true) {
			int choicePick = 0;
			System.out.println("Choose action: ");
			System.out.println("1. Attack "+e1.getName());
			choicePick = scan.nextInt();
			scan.nextLine();
			
			if(choicePick ==1) {
				
				
				if(p1.isAlive()) {
					p1.attack(e1);
				}
				
				if(e1.isAlive()) {
					e1.attack(p1);
				}
				if(e1.isAlive() ==false) {
					System.out.println("Thanos loot found!, you can now equip and use.");
					p1.equipitem();
					p1.useItem();
					p1.unequipItem();
					System.out.println("Thank for playing!");
					System.exit(0);
				}
				
			}

			

		}
		
		
		
		

	}
}


