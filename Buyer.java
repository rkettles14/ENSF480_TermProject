

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
        while(true){
            System.out.println("Enter 1 to search for document.");
            System.out.println("Enter 2 to place an order.");
            System.out.println("Enter 3 to make payment.");
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
        
    }
    
    public void searchForDocument(String query){
        int target = Integer.parseInt(query);
        Document d = instance.getDatabase().searchForDocument(target);
        if(d==null){
            return;
        }
        System.out.println("Search Results: ");
        d.display();
    }
    
}
