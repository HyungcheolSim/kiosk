public class Order extends Product{
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order(String catName, String catComment, String pdName, int price, String pdComment) {
        super(catName, catComment, pdName, price, pdComment);
        this.count++;
    }

    public Order(Product product) {
        super(product.getCatName(), product.getCatComment(), product.getPdName(), product.getPrice(), product.getPdComment());
        this.count++;
    }
}
