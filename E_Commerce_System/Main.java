package E_Commerce_System;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product product1 = new Product(1, "Apple", 20, 100);
		Product product2 = new Product(2,"Banana",30,300);
		
		Map<Integer, Product> productList = new HashMap<>();
		
		productList.put(product1.getProductId(),product1);
		productList.put(product2.getProductId(),product2);
		
		
		Customer customer1 = new Customer(1,"Alan","alankluke@gmail.com");
		Customer customer2 = new Customer(2,"Mathew","mathew@gmail.com");
		
		Order order1 = new Order(1, customer1);
		Order order2 = new Order(2, customer2);
		
		order1.addProduct(product1, 10);
		order2.addProduct(product2, 30);
		
       
        customer1.printCustomerDetails();
        System.out.println("Total to be paid by "+customer1.getName()+" is " + order1.calculateTotal(productList));
        System.out.println(" ");
        customer2.printCustomerDetails();
        System.out.println("Total to be paid by "+customer2.getName()+" is " + order2.calculateTotal(productList));
	}

}
