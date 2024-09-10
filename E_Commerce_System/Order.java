package E_Commerce_System;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Order {
	
	private int orderId;
    private Customer customer;
    private Map<Integer, Integer> items; 
    
   
    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>();
    }

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("stock not available for product: " + product.getName());
        }
        items.put(product.getProductId(), items.getOrDefault(product.getProductId(), 0) + quantity);
    }
	
	public void removeProduct(Product product) {
		
		if (!items.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("product not found");
            
        } else {
            items.remove(product.getProductId());
        }
	}
	public double calculateTotal(Map<Integer, Product> productList) {
		
        double total = 0.0;
        
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
        	
            int productId = entry.getKey();
            int quantity = entry.getValue();
            
            Product product = productList.get(productId);
            
            if (product != null) {
                total += product.getPrice() * quantity;
            } else {
                throw new IllegalStateException("Product not found");
            }
        }
        return total;
    }
}
