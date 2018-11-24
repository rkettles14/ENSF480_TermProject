
import java.util.Scanner;

public  abstract class User {
    protected Scanner stdin;
    protected Server instance;
    
   public User(){
       stdin = new Scanner(System.in);
       instance.getInstance();
   }
    
    /**
     * shows what the user can do to std out
     * ie "press 1 to add publication"
     */
    public abstract void showOptions();
    
}
