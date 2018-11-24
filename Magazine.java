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
    public Magazine(String authorName, String path, int isbn, int stockCount) {
        super(authorName, path, isbn, stockCount);
        setPublishStrategy(new MagazinePublisher());
        this.publishInfo = "Magazines can have art on the front. Will implement l8r";
    }
}
