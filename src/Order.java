public class Order extends Product {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order(Product product) {
        super(product.getName(), product.getDescription(), product.getPrice());
        this.count++;
    }
}
