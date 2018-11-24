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
    
    public void publish(String info){
        System.out.println(info);
    }
}
