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
    
    
        public void showOptions() {
        while(notquit){
            System.out.println("Enter 1 to search for document.");
            System.out.println("Enter 2 to make payment.");
            System.out.println("Enter 3 to unregister");
            System.out.println("Enter 'Q' to quit");
            String input = stdin.nextLine();
            if(input.matches("Q")){
                break;
            }


            while(true){
                if(input.matches("1")){
                    System.out.println("Please enter the ISBN of the document you wish to search for");
                    searchForDocument(stdin.nextLine());
                    System.out.println("\n");
                    break;

                }
                else if(input.matches("2")){
                    makePayment();
                    break;
                }
                else if (input.matches("3")){
                    unsubscribe();
                    break;
                }
                
                else{
                    System.out.println("invalid input.");
                    break;
                }
            }
        }
        
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
        Buyer b = new Buyer();
        b.setCart(this.getCart());
        this.notquit = false;
        instance.users.remove(this);
        instance.users.add(b);
        System.out.println("You have sucessfully unsibscribed. Your card will no longer be charged");
        b.showOptions();
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
