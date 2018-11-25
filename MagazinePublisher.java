/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
public class MagazinePublisher implements PublishStrategy{
    public String publishInfo = "Magazines can have art on the front. Will implement l8r";
    public void publish(){
        System.out.println(publishInfo);
    }
}
