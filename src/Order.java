public class Order extends Product{
    public Order(String catName, String catComment, String pdName, int price, String pdComment) {
        super(catName, catComment, pdName, price, pdComment);
    }

    public Order(Product product) {
        super(product.getCatName(), product.getCatComment(), product.getPdName(), product.getPrice(), product.getPdComment());
    }
}
