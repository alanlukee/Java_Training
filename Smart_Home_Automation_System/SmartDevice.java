package Smart_Home_Automation_System;

abstract class SmartDevice {
	
	int deviceId;
	
	public SmartDevice(int deviceId) {
		// TODO Auto-generated constructor stub
		this.deviceId = deviceId;
	}
	
	public abstract void operate(String command, int setting, String mode);
	
	public abstract void displayStatus();

}
