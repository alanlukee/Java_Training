package Fitness_Tracking_Application;

public class ExerciseTracker {
	
	int calories_per_minute;
	int met_low = 3;
	int met_medium = 6;
	int met_high = 9;
	
	public void calculateCaloriesBurned(int duration,String intensity) {
		
		
		if(intensity =="low") {
			calories_per_minute = 4;
		}
		else if(intensity == "medium") {
			calories_per_minute = 7;
			
		}
		else if (intensity == "high") {
			
			calories_per_minute = 10;
			
		}
		else {
			System.out.println("invalid intensity");
		}
		
		System.out.println("Calories Burned: "+ (calories_per_minute * duration));
		
	}
	
	
	public void calculateCaloriesBurned(int duration,String intensity, double weight) {
		
		if(intensity =="low") {
			
			System.out.println("Calories burned: "+met_low*(duration/60)*weight);
			
		}
		else if(intensity == "medium") {
			//calories_per_minute = 7;
			System.out.println("Calories burned: "+met_medium*(duration/60)*weight);
			
		}
		else if (intensity == "high") {
			
			//calories_per_minute = 10;
			
			System.out.println("Calories burned: "+met_high*(duration/60)*weight);
			
		}	
	}
	
	public void calculateCaloriesBurned(int duration,String intensity, double weight, String exerciseType) {
		
		double durationInHours = duration / 60.0;
	    

	    double metValue = 0;
	    
	    switch (exerciseType.toLowerCase()) {
	        case "running":
	        	
	            if (intensity.equals("low")) {
	                metValue = 6;
	            } else if (intensity.equals("medium")) {
	                metValue = 9;
	            } else if (intensity.equals("high")) {
	                metValue = 12;
	            } else {
	                System.out.println("Invalid intensity for Running.");
	                return;
	            }
	            break;
	        
	        case "cycling":
	            if (intensity.equals("low")) {
	                metValue = 4;
	            } else if (intensity.equals("medium")) {
	                metValue = 8;
	            } else if (intensity.equals("high")) {
	                metValue = 12;
	            } else {
	                System.out.println("Invalid intensity for Cycling.");
	                return;
	            }
	            break;
	        
	        case "swimming":
	            if (intensity.equals("low")) {
	                metValue = 6;
	            } else if (intensity.equals("medium")) {
	                metValue = 8;
	            } else if (intensity.equals("high")) {
	                metValue = 11;
	            } else {
	                System.out.println("Invalid intensity for Swimming.");
	                return;
	            }
	            break;
	        
	        default:
	            System.out.println("Invalid exercise type.");
	            return;
	    }
	    
	    
	    double caloriesBurned = metValue * weight * durationInHours;
	    
	    
	    System.out.println("Calories burned: " + caloriesBurned);
		
	}

}


