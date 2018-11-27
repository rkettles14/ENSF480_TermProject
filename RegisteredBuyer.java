/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegisteredBuyer extends Buyer implements Observer{
    
    private Subject notifier;
    private ArrayList<Promotion> promotions;
    private Scanner scan;
    
    public RegisteredBuyer() {
        super();
        promotions = new ArrayList<Promotion>();
        File file = new File("PromotionsList.txt"); 
        try {
            scan = new Scanner(file);
        } 
        catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
        BuyerNotifier bn = new BuyerNotifier();
        bn.register(this);
        this.setSubject(bn);
        initializePromos();
        //bn.addPromotion(new Promotion(promos, 0.8));
    }
    
    @Override
    public void makePayment(){
        System.out.println("These are all of the items in your cart: ");
        double total = 0;
        
        for(Document d : getCart()){
        	boolean isDiscounted = false;
            d.display();
            for(int i = 0; i < promotions.size(); i++) {
            	for(int j = 0; j < promotions.get(i).getProducts().size(); j++)
            	{
            		if(d.getIsbn() == promotions.get(i).getProducts().get(j).getIsbn()) {
            			total += d.getPrice()*promotions.get(i).getDiscount();
            			isDiscounted = true;
            			break;
            			
            		}
            		
            	   
            	}
            }
            if(!isDiscounted)
            	total += d.getPrice();
        }
        System.out.println("This comes to a total price of: " + total);
        System.out.println("Please enter your credit card nmber");
        int cardNum = Integer.parseInt(stdin.nextLine());
        System.out.println("Please enter the name on your card: ");
        String name = stdin.nextLine();
        System.out.println("Please enter your billing address: ");
        String billingInfo = stdin.nextLine();
        
        Transaction t = new Transaction(this.getCart(), cardNum, total, name, billingInfo);
        System.out.println("\n\nCreated new transaction: \n");
        t.display();
        this.setCart(new ArrayList<>());
    }
    
        public void showOptions() {
        while(notquit){
            System.out.println("Enter 1 to search for document.");
            System.out.println("Enter 2 to make payment.");
            System.out.println("Enter 3 to unregister");
            System.out.println("Enter 4 to view promotions list");
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
                
                else if(input.matches("4")) {
                	 
                     this.browsePromotions();
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
    
    public void initializePromos()
    {
    	while(scan.hasNextLine()){
    		 ArrayList<Document>promos = new ArrayList<Document>();
    		int discounts = scan.nextInt();
    		for(int i = 0; i < discounts; i++)
    		{
    			int target = scan.nextInt();
    			Document d = instance.getDatabase().searchForDocument(target);
    			promos.add(d);
    		}
            double deal = scan.nextDouble();
    		Promotion promo = new Promotion(promos, deal);
            promotions.add(promo);
            }
        }
 
}
