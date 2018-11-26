

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
    
    
    @Override
    public void showOptions() {
        while(true){
            System.out.println("Enter 1 to search for document.");
            System.out.println("Enter 2 to make payment.");
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
                else{
                    System.out.println("invalid input.");
                    break;
                }
            }
        }
        
    }
    
    public void makePayment(){
        System.out.println("These are all of the items in your cart: ");
        for(Document d : cart){
            d.display();
        }
        
        
    }
    
    public void searchForDocument(String query){
        int target = Integer.parseInt(query);
        Document d = instance.getDatabase().searchForDocument(target);
        if(d==null){
            return;
        }
        System.out.println("Search Results: ");
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
