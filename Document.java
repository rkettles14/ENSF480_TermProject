/**
 *
 * @author Zach Sims, Rylan Kettles, Brandon Khoo
 */
public abstract class Document {
       protected String title;
       protected String authorName;
       protected String path;
       protected int isbn;
       protected int stockCount;
       protected double price;
       protected PublishStrategy publishStrategy;
       public abstract String getType();

    public Document(String title, String authorName, double price, int isbn, String path , int stockCount) {
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.path = path;
        this.stockCount = stockCount;
        this.price = price;
    }
    
    public void setPublishStrategy(PublishStrategy strategy){
        this.publishStrategy = strategy;
    }
    
    public void executeStrategy(){
        publishStrategy.publish();
    }
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void display(){
        System.out.println("Title: " + title);
        System.out.println("Name of Author: " + authorName);
        System.out.println("Price: " + price);
        System.out.println("Path to document: " + path);
        System.out.println("ISBN: " + isbn);
        System.out.println("Remaining Stock: " + stockCount);
    }
}
