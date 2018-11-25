

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
                System.out.println("implement later");
                break;
                //call add
            }
            else if(input.matches("2")){
                System.out.println("implement later");
                break;
                //call remove

            }
            else if(input.matches("3")){
                System.out.println("implement later");
                break;
                //call update
            }
            else{
                System.out.println("invalid input.");

            }
        }
        
    }
    
}
