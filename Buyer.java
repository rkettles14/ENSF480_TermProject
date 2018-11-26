

/**
 *
 * @author Rylan, Zach Brandon
 */
public class Buyer extends User{
    
    public Buyer(){
        super();
    }

    @Override
    public void showOptions() {
        System.out.println("Press 1 to search for document.");
        System.out.println("Press 2 to place an order.");
        System.out.println("Press 3 to make payment.");
        
        
        while(true){
            String input = stdin.nextLine();
        
            if(input.matches("1")){
                System.out.println("Please enter the ISBN of the document you wish to search for");
                searchForDocument(stdin.nextLine());
                break;
                
            }
            else if(input.matches("2")){
                System.out.println("implement later");
                break;
                

            }
            else if(input.matches("3")){
                System.out.println("implement later");
                break;
                
            }
            else{
                System.out.println("invalid input.");

            }
        }
        
    }
    
    public void searchForDocument(String query){
        int target = Integer.parseInt(query);
        Document d = instance.getDatabase().searchForDocument(target);
        if(d==null){
            return;
        }
        System.out.println("Search Results: ");
        System.out.println("    Title: " + d.getTitle());
        System.out.println("    Author: " + d.getAuthorName());
        System.out.println("    ISBN: " + d.getIsbn());
        System.out.println("    Number in stock: " + d.getStockCount()); 
    }
    
}
