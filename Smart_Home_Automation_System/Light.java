package Smart_Home_Automation_System;

public class Light extends SmartDevice {
	
	int brightness;
	boolean flag;

	public Light(int deviceId) {
		super(deviceId);
		this.brightness = 10;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void operate(String command, int setting, String mode) {
		if(command.equals("ON")) {
			flag = true;
			System.out.println("Light turned ON with brighness "+setting+"%");
		}
		else if(command.equals("OFF")) {
			System.out.println("Light turned OFF");
			
		}
		else {
			System.out.println("invalid");
		}
		
	}

	@Override
	public void displayStatus() {
		if(flag==true) {
			System.out.println("Light Status: ON");
			
		}
		else {
			System.out.println("Light Status: OFF");
		}
		
		
	}

}
