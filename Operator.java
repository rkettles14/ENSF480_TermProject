
/**
 *
 * @author Rylan, Zach, Brandon
 */
public class Operator extends User{

    public Operator(){
        super();
        
    }
    
    @Override
    public void showOptions() {
        System.out.println("Press 1 to add document.");
        System.out.println("Press 2 to remove document.");
        System.out.println("Press 3 to update document.");
        
        
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
    
    /**
     * Main for testing
     * @param args 
     */
    public static void main(String[] args){
        //Operator op = new Operator(); Commented out by Zach
        //op.showOptions(); Commented out by Zach
        
        Book testBook = new Book("Zaddy Sims", "Yer mums house", 69, 420);
        testBook.executeStrategy();
        System.out.printf("Imma make the book publish like a magazine now just 2 see\n");
        testBook.setPublishStrategy(new MagazinePublisher());
        testBook.executeStrategy();
    }
    
}
