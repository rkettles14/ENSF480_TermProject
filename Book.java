/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
public class Book extends Document{
    
    
    public Book(String authorName, String path, int isbn, int stockCount) {
        super(authorName, path, isbn, stockCount);
        setPublishStrategy(new BookPublisher());
        this.publishInfo = "Books can be hard or soft covered. Will implement l8r";
    }
    
    
}
