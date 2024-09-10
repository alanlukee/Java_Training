package Fitness_Tracking_Application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("input duration: ");
		int duration = scan.nextInt();
		System.out.println("input intensity: ");
		String intensity = scan.next();
		System.out.println("input weight: ");
		double weight = scan.nextDouble();
		System.out.println("input exercise type: ");
		String Extype = scan.next();
		scan.close();
		
		ExerciseTracker et = new ExerciseTracker();
		
		
		et.calculateCaloriesBurned(duration,intensity,weight,Extype);

		
	}

}
