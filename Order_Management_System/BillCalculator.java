package Order_Management_System;

public class BillCalculator {
	
	double orderAmt;
	double disc;
	String custType;
	double custDisc;

	public BillCalculator(double orderAmt, double disc, String custType) {
		// TODO Auto-generated constructor stub
		
		this.orderAmt = orderAmt;
		this.disc = disc;
		this.custType = custType;
	}
	public double calculateBill(double orderAmt) {
		
		return orderAmt;
		
	}
	public double calculateBill(double orderAmt,double disc) {
        double discountAmount = orderAmt * (disc / 100);
        return orderAmt - discountAmount;
		
	}
	public double calculateBill(double orderAmount,double discount, String custType) {

        double discountAmount = orderAmount * (discount / 100);
        return orderAmount - discountAmount;
		
	}

}

