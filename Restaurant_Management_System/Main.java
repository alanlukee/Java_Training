package Restaurant_Management_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        OrderCalculator calc = new OrderCalculator();
        
        System.out.println("input items required(FoodItem, BeverageItem, DessertItem)-comma separated: ");
        String items = scan.nextLine();
        
        
        List<String> itemList = new ArrayList<>();
       
        String[] itemArray = items.split(",");

		int foodQuant = 0;
		int beverageQuant = 0;
		int dessertQuant = 0;

		for (String item : itemArray) {
			itemList.add(item.trim());
		}

		for (String i : itemArray) {
			if (i.toLowerCase().equals("fooditem")) {
				System.out.println("enter quantity of food item: ");
				foodQuant = scan.nextInt();

        	}
        	else if(i.toLowerCase().equals("beverageitem")) {
        		System.out.println("enter quantity of beverage item: ");
        		beverageQuant = scan.nextInt();

        	}
        	else if(i.toLowerCase().equals("dessertitem")) {
        		System.out.println("enter quantity of dessert item: ");
        		dessertQuant = scan.nextInt();
        		
        	}
        	else {
        		System.out.println("invalid itemName");
        	}
        }
        
        List<MenuItem> orderList = new ArrayList<>();

        
        if(itemList.contains("FoodItem")) {
        	MenuItem fooditem = new FoodItem();
        	fooditem.quantity = foodQuant;
        	fooditem.itemName = "FoodItem";
        	orderList.add(fooditem);
        }
        if(itemList.contains("BeverageItem")) {
        	MenuItem beverageitem = new BeverageItem();
        	beverageitem.quantity = beverageQuant;
        	beverageitem.itemName = "BeverageItem";
        	orderList.add(beverageitem);
        	

        }
        if(itemList.contains("DessertItem")) {
        	MenuItem dessertitem = new DessertItem();
        	dessertitem.quantity = dessertQuant;
        	dessertitem.itemName = "DessertItem";
        	orderList.add(dessertitem);
        }
        
        double withoutDiscountAndTax = calc.calculateTotalCost(orderList);
        double withDiscount = calc.calculateTotalCost(orderList, "JAVA2024");
        double withDiscountAndTax = calc.calculateTotalCost(orderList, "JAVA2024", 20);
        
        System.out.println(" ");
        System.out.println("Restaurant_Management_System");
        System.out.println(" ");
        System.out.println("Items ordered are: ");
        System.out.println(" ");

        
        for (MenuItem i : orderList) {
        	System.out.println(i.itemName+", "+ i.quantity+" nos: "+"of price, "+i.getPrice()+" rupees each");
        }
        System.out.println(" ");
        
        System.out.println("Rate without discount and tax: "+withoutDiscountAndTax+" rupees");
        System.out.println("Rate with discount: "+withDiscount+" rupees");
        System.out.println("Rate with discount and tax: "+withDiscountAndTax+" rupees");
        
        scan.close();
    }
}
