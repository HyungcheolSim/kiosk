

public class Product extends Category{
    private String pdName;
    private int price;
    private String pdComment;
    private String option;



    public Product(String catName, String catComment, String pdName, int price, String pdComment) {
        super(catName, catComment);
        this.pdName = pdName;
        this.price = price;
        this.pdComment = pdComment;
        this.option="Single";
    }

    public Product(Product product) {
        super(product.getCatName(),product.getCatComment());
        this.pdName = product.getPdName();
        this.price = product.getPrice();
        this.pdComment = product.getPdComment();
        this.option=product.getOption();
    }

    //single(기본) Set///버거,single(기본) Combo///샐러드 Midium(기본),Large//사이드
    public void setOptionSet() {
        this.setOption("Set");
        this.setPdName(this.getPdName()+"(SET)");
        this.setPrice((int)(1.3*this.getPrice()));
        this.setPdComment(this.getPdComment()+" 세트");
    }

    public void setPdComment(String pdComment) {
        this.pdComment = pdComment;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public void setPrice(int price) {
        this.price = price;
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
    public String getOption() {
        return option;
    }

}
