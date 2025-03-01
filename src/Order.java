import java.io.FileWriter;
import java.io.IOException;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void placeOrder() {
        System.out.println("Order Summary:");
        for (Product product : cart.getProducts()) {
            System.out.println(product.getName() + " ₹" + product.calculatePrice());
        }
        System.out.println("Total: ₹" + cart.calculateTotal());
    }

    public void saveOrder(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Product product : cart.getProducts()) {
                writer.write(product.getName() + " - ₹" + product.calculatePrice() + "\n");
            }
            writer.write("Total: ₹" + cart.calculateTotal());
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }
}