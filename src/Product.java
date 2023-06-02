public class Product extends Category {

    private double price;
    private String option;


    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
        this.option = "Single";
    }

    public Product(Product product) {
        super(product.getName(), product.getDescription());
        this.price = product.getPrice();
        this.option = product.getOption();
    }

    //single(기본) Set///버거,single(기본) Combo///샐러드 Medium (기본),Large//사이드
    public void setOptionSet() {
        this.setOption("Set");
        this.setName(this.getName() + "(SET)");
        this.setPrice(1.3 * this.getPrice());
        this.setDescription(this.getDescription() + " 세트");
    }


    public void setOption(String option) {
        this.option = option;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getOption() {
        return option;
    }

}

