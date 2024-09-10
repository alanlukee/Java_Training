package Medical_Billing_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BillingCalculator calc = new BillingCalculator();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter services required(Surgery, DoctorVisit, LabTest)-comma separated: ");
		String servicesString = scan.nextLine();
		System.out.println("Enter insurance coverage: ");
		double insur = scan.nextDouble();
		System.out.println("Enter Co-payment policy: ");
		double cppolicy = scan.nextDouble();


		InsurancePlan insurance = new InsurancePlan(insur);
		CoPaymentPolicy policy = new CoPaymentPolicy(cppolicy);
		
		scan.close();
		
		List<String> servicesList = new ArrayList<>();

		String[] servicesArray = servicesString.split(",");
		
		for (String item : servicesArray) {
			servicesList.add(item.trim());
			
		}
		
		List<MedicalService> medicalServiceList = new ArrayList<>();

        
        if(servicesList.contains("Surgery")) {
        	MedicalService surgery = new Surgery("Surgery");
        	
        	medicalServiceList.add(surgery);
        }
        if(servicesList.contains("DoctorVisit")) {
        	MedicalService docvisit = new DoctorVisit("Doctor Visit");
        	medicalServiceList.add(docvisit);
        }
        if(servicesList.contains("LabTest")) {
        	MedicalService labtest = new LabTest("Lab Test");
        	
        	medicalServiceList.add(labtest);
        }
        
        double costWithService = calc.calculateBill(medicalServiceList) ;
        double costWithServiceAndInsurance = calc.calculateBill(medicalServiceList, insurance);
        double costWithServiceInsuranceAndPolicy = calc.calculateBill(medicalServiceList, insurance, policy);
        
        
        System.out.println(" ");
        System.out.println("Medical_Billing_System");
        System.out.println(" ");
        System.out.println("Services opted are: ");
        System.out.println(" ");

        
        for (MedicalService i : medicalServiceList) {
        	System.out.println(i.medicalServiceName);
        }
        System.out.println(" ");
        System.out.println("Rate only with service: "+costWithService+" rupees");
        System.out.println("Rate with service and insurance coverage: "+costWithServiceAndInsurance+" rupees");
        System.out.println("Rate with service, insurance coverage and co-payment policy: "+costWithServiceInsuranceAndPolicy+" rupees");
	}

}
