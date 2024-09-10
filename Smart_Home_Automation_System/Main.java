package Smart_Home_Automation_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
        SmartDevice selectedDevice = null;
        DeviceController controller = new DeviceController();

        System.out.println("Smart Home Automation System");

        
        System.out.println("Choose a device to control: 1.Light 2.Fan 3.Thermostat");
        int deviceChoice = scanner.nextInt();

        
        switch (deviceChoice) {
            case 1:
                selectedDevice = new Light(101);  
                break;
            case 2:
                selectedDevice = new Fan(102);  
                break;
            case 3:
                selectedDevice = new Thermostat(103); 
                break;
            default:
                System.out.println("Invalid choice");
                 
        }
        
        System.out.println("Enter command (ON/OFF):");
        String command = scanner.next();

        
        System.out.println("Do you want to adjust settings? (yes/no):");
        String set = scanner.next();

        if (set.equals("yes")) {
            System.out.println("Enter setting (Brightness for Light, Speed for Fan, Temperature for Thermostat):");
            int setting = scanner.nextInt();

            System.out.println("Do you want to set a mode? (yes/no):");
            String mode = scanner.next();

            if (mode.equals("yes")) {
            	
                System.out.println("Enter mode(Energy Saver, Turbo, Normal):");
                
                String setmode = scanner.next();
                controller.controlDevice(selectedDevice.deviceId, command, setting, setmode);
                selectedDevice.operate(command, setting, mode);  
            } else {
                controller.controlDevice(selectedDevice.deviceId, command, setting);
                selectedDevice.operate(command, setting, null);  
            }
        } else {
            controller.controlDevice(selectedDevice.deviceId, command);
            selectedDevice.operate(command, 0, null);  
        }

        
        System.out.println("\nDevice Status:");
        selectedDevice.displayStatus();

       
        scanner.close();
    }
}
