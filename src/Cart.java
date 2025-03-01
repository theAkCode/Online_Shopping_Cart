import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;
    private double discount = 0.0;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new NullPointerException("Cannot add null product.");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (!products.remove(product)) {
            throw new IllegalArgumentException("Product not found in the cart.");
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void applyCoupon(String code) {

        if (code.equals("SAVE10")) {
            discount = 0.10;
        } else {
            System.out.println("Invalid coupon code:" + code);
        }

    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.calculatePrice();
        }
        return total * (1 - discount);
    }
}
