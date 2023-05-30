public class Category {
    private final String catName;
    private final String catComment;

    public Category(String catName, String catComment) {
        this.catName = catName;
        this.catComment = catComment;
    }
    public String getCatName() {
        return catName;
    }

    public String getCatComment() {
        return catComment;
    }

}
