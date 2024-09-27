package E_Commerce_System_2;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        Product apple = new Product("P1", "Apple", 0.60, 100);
        Product orange = new Product("P2", "Banana", 0.80, 100);

        
        Customer customer = new Customer("C1", "Alan", "alankluke@gmail.com");

       
        Order order = new Order("O1", customer);

        
        order.addItem(apple, 10);
        order.addItem(orange, 5);

        
        System.out.println("Items:");
        
        for (Map.Entry<Product, Integer> entry : order.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Quantity: " + quantity + ", Price: " + product.getPrice());
        }
        System.out.println("Total Price: $" + order.calculateTotal());

        order.removeItem(orange);
        System.out.println("Total Price after removing oranges: $" + order.calculateTotal());
    }
}
