public class Product extends Category{
    private final String pdName;
    private final int price;
    private final String pdComment;


    public Product(String catName, String catComment, String pdName, int price, String pdComment) {
        super(catName, catComment);
        this.pdName = pdName;
        this.price = price;
        this.pdComment = pdComment;
    }

    public String getPdName() {
        return pdName;
    }

    public int getPrice() {
        return price;
    }

    public String getPdComment() {
        return pdComment;
    }

}
