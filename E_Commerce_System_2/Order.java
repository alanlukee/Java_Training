package E_Commerce_System_2;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> items;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>();
    }

    
    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getItems() {
        return new HashMap<>(items); 
    }

   
    public void addItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        
        if (items.containsKey(product)) {
           
            int currentQuantity = items.get(product);
            items.put(product, currentQuantity + quantity);
        } else {
           
            items.put(product, quantity);
        }
    }

    
    public void removeItem(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }

        
        if (!items.containsKey(product)) {
            throw new IllegalArgumentException("Product is not in the order.");
        }

       
        items.remove(product);
    }

    
    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }
}
