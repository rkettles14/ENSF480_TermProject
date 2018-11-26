/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
public class Journal extends Document{
    public Journal(String title, String authorName, double price, int isbn, String path, int stockCount) {
        super(title, authorName, price, isbn, path, stockCount);
        setPublishStrategy(new JournalPublisher());
    }

    @Override
    public String getType() {
        return "J";
    }
    
}
