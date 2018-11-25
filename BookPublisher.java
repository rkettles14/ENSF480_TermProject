/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
public class BookPublisher implements PublishStrategy{
    public String publishInfo = "Books can be hard or soft covered. Will implement l8r";
    public void publish(){
        System.out.println(publishInfo);
    }
}
