
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
public class BuyerNotifier implements Subject{
    
    private ArrayList<Observer> customers;
    private ArrayList<Promotion> promotions;

    public BuyerNotifier() {
        customers = new ArrayList<>();
        promotions = new ArrayList<>();
    }
    
    
    public void register(Observer obj){
                customers.add(obj);
    }
    
    public void unregister(Observer obj){
        customers.remove(obj);
    }
    
    public void notifyObservers(){
        for(Observer obj : customers){
            obj.update();
        }
    }
    
    public ArrayList<Promotion> getUpdate(Observer obj){
        return this.promotions;
    }
    
    public void addPromotion(Promotion p){
        promotions.add(p);
        notifyObservers();
    }
}
