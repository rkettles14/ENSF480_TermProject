/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
public class Magazine extends Document{
    
    public Magazine(String title, String authorName, String path, int stockCount) {
        super(title, authorName, path, stockCount);
        setPublishStrategy(new MagazinePublisher());
    }

    @Override
    public String getType() {
        return "M";
    }
    
}
