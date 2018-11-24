/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zach Sims, Rylan Kettles, Brandon Khoo
 */
public class Document {
       private String authorName;
       private String path;
       private int isbn;
       private int stockCount;

    public Document(String authorName, String path, int isbn, int stockCount) {
        this.authorName = authorName;
        this.path = path;
        this.isbn = isbn;
        this.stockCount = stockCount;
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

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
