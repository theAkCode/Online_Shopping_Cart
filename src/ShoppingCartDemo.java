public class ShoppingCartDemo {
    public static void main(String[] args) {
        Cart cart = new Cart();
        try {
            // Test 1: Add valid products
            System.out.println("Adding valid products...");
            cart.addProduct(new Electronics("Laptop", 1000));
            cart.addProduct(new Clothing("T-Shirt", 50));
            System.out.println("Products added successfully.\n");

            // Test 2: Validate price calculations
            System.out.println("Validating price calculations...");
            for (Product product : cart.getProducts()) {
                System.out.println(product.getName() + " Calculated Price: $" + product.calculatePrice());
            }
            System.out.println();

            // Test 3: Handle invalid product additions
            try {
                System.out.println("Attempting to add a null product...");
                cart.addProduct(null);
            } catch (NullPointerException e) {

                System.out.println("Caught exception: " + e.getMessage());
            }
            System.out.println();

            // Test 4: Handle invalid product removal
            try {
                System.out.println("Attempting to remove a non-existent product...");
                cart.removeProduct(new Electronics("Phone", 800));
            } catch (IllegalArgumentException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }

            System.out.println();

            // Test 5: Apply valid and invalid coupon codes
            System.out.println("Applying valid coupon...");
            cart.applyCoupon("SAVE10");
            System.out.println("Coupon applied. Total after discount: $" + cart.calculateTotal());
            System.out.println("Applying invalid coupon...");
            cart.applyCoupon("INVALIDCODE");
            System.out.println();

            // Test 6: Confirm correct order summary
            System.out.println("Placing order...");
            Order order = new Order(cart);
            order.placeOrder();

            // Save the order to a file
            System.out.println("\nSaving order to file...");
            order.saveOrder("order.txt");
            System.out.println("Order saved successfully.");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}