package Smart_Home_Automation_System;

public class DeviceController {
	
	
    public void controlDevice(int deviceId, String command) {
        System.out.println("Device " + deviceId + " got command: " + command);
    }
    
   
    public void controlDevice(int deviceId, String command, int setting) {
        System.out.println("Device " + deviceId + " got command: " + command + " with setting: " + setting);
    }
    
    public void controlDevice(int deviceId, String command, int setting, String mode) {
        System.out.println("Device " + deviceId + " got command: " + command + " with setting: " + setting + " in " + mode + " mode");
    }

}
