public class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return getPrice() * 1.18;
    }
}