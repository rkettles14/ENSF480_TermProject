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
    
    public Book(String title, String authorName, String path, int stockCount) {
        super(title, authorName, path, stockCount);
        setPublishStrategy(new BookPublisher());
    }

    @Override
    public String getType() {
        return "B";
    }
    
    
}
