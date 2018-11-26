/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */

import java.util.ArrayList;

public class RegisteredBuyer extends Buyer implements Observer{
    
    private Subject notifier;
    private ArrayList<Promotion> promotions;

    public RegisteredBuyer() {
        super();
        promotions = new ArrayList<Promotion>();
    }
    
    public void update(){
        promotions = notifier.getUpdate(this);
    }
    
    public void setSubject(Subject sub){
        this.notifier = sub;
    }
    
    public void browsePromotions(){
        System.out.printf("These are all of the current promotions\n\n");
        for(Promotion p : promotions){
            p.display();
        }
    }
    
    public void unsubscribe(){
        notifier.unregister(this);
    }
    
    public static void main(String []args){
        RegisteredBuyer rb = new RegisteredBuyer();
        BuyerNotifier bn = new BuyerNotifier();
        bn.register(rb);
        rb.setSubject(bn);
        Book book = new Book("Cool Books r Cool", "Dick Cockfield", 69.69, 10, "Yermumshouse", 69);
        ArrayList<Document> promos = new ArrayList<>();
        promos.add(book);
        bn.addPromotion(new Promotion(promos, 0.8));
        rb.browsePromotions();
    }
}
