package Smart_Home_Automation_System;

public class Thermostat extends SmartDevice {
	
	int temperature;
	boolean flag;

	public Thermostat(int deviceId) {
		super(deviceId);
		this.temperature = 24;
		
	}

	@Override
	public void operate(String command, int setting, String mode) {
		
		if (command.equals("ON")) {
            flag = true;
            
            System.out.println("Thermostat turned ON. Temperature is set to " + setting + "°C");
        } else if (command.equals("OFF")) {
            flag = false;
            System.out.println("Thermostat is OFF.");
        } 
        else {
        	System.out.println("invalid");
        }
		
	}

	@Override
	public void displayStatus() {
		
		if(flag==true) {
			System.out.println("Thermostat Status: ON");
			
		}
		else {
			System.out.println("Thermostat Status: OFF");
		}
		
	}

}
