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
    public Journal(String authorName, String path, int isbn, int stockCount) {
        super(authorName, path, isbn, stockCount);
        setPublishStrategy(new JournalPublisher());
        this.publishInfo = "Journals can have a font maybe?? idk. Will implement l8r";
    }
    
}
