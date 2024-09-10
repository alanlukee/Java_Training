package Smart_Home_Automation_System;

public class Fan extends SmartDevice {
	
	int speed;
	boolean flag ;

	public Fan(int deviceId) {
		super(deviceId);
		this.speed = 5;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operate(String command, int setting, String mode) {
		
		if (command.equals("ON")) {
            flag = true;
            
            System.out.println("Fan turned ON. Speed is set to " + setting);
        } else if (command.equals("OFF")) {
            flag = false;
            System.out.println("Fan is OFF.");
        } else {
            System.out.println("invalid");
        }
		
	}

	@Override
	public void displayStatus() {
		// TODO Auto-generated method stub
		if(flag==true) {
			System.out.println("Fan Status: ON");
			
		}
		else {
			System.out.println("Fan Status: OFF");
		}
		
	}

}
