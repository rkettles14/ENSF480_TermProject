

/**
 *
 * @author Rylan, Zach, Brandon
 */

import java.util.ArrayList;
public class Buyer extends User{
    
    private ArrayList<Document> cart;
    
    public Buyer(){
        super();
        cart = new ArrayList<>();
    }

    public ArrayList<Document> getCart() {
        return cart;
    }
    public void setCart(ArrayList<Document> cart){
        this.cart = cart;
    }
    
    @Override
    public void showOptions() {
        while(notquit){
            System.out.println("Enter 1 to search for document.");
            System.out.println("Enter 2 to make payment.");
            System.out.println("Enter 3 to become a registered buyer");
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
                    makeRegisteredBuyer();
                    break;
                }
                
                else{
                    System.out.println("invalid input.");
                    break;
                }
            }
        }
        
    }
    
    public void makeRegisteredBuyer(){
        
        System.out.println("Please enter your credit card number\n");
        int cardNum = Integer.parseInt(stdin.nextLine());
        System.out.println("Thank you, your card will be charged a subscription fee each month.");
        RegisteredBuyer rb = new RegisteredBuyer();
        rb.setSubject(instance.notifier);
        instance.notifier.register(rb);
        rb.setCart(this.getCart());
        this.notquit = false;
        instance.users.remove(this);
        instance.users.add(rb);
        rb.showOptions();
        
        
    }
    public void makePayment(){
        System.out.println("These are all of the items in your cart: ");
        double total = 0;
        for(Document d : cart){
            d.display();
            
            total += d.getPrice();
        }
        System.out.println("This comes to a total price of: " + total);
        System.out.println("Please enter your credit card nmber");
        int cardNum = Integer.parseInt(stdin.nextLine());
        System.out.println("Please enter the name on your card: ");
        String name = stdin.nextLine();
        System.out.println("Please enter your billing address: ");
        String billingInfo = stdin.nextLine();
        
        Transaction t = new Transaction(cart, cardNum, total, name, billingInfo);
        System.out.println("\n\nCreated new transaction: \n");
        t.display();
        cart = new ArrayList<>();
    }
    
    public void searchForDocument(String query){
        int target = Integer.parseInt(query);
        Document d = instance.getDatabase().searchForDocument(target);
        if(d==null){
            return;
        }
        System.out.println("\nSearch Results: ");
        d.display();
        
        System.out.println("\nWould you like to add this item to your cart? Y/N");
        String input = stdin.nextLine();
        if(input.matches("Y")){
            if(d.getStockCount() <= 0){
                System.out.println("Sorry, that item is out of stock");
                return;
            }
            d.setStockCount(d.getStockCount() -1);
            cart.add(d);
        }
    }
    
}
