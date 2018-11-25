
import java.util.Scanner;

public  abstract class User {
    protected Scanner stdin;
    protected Server instance ;
    private String username;
    private String password;
    
   public User(){
	  
       stdin = new Scanner(System.in);
      
       instance = Server.getInstance();
       
   }
    
   public void setPassword(String pass)
   {
	   password = pass;
   }
   
   public void setUsername(String user)
   {
	   username = user;
   }
   
   public String getPassword()
   {
	   return password;
   }
   
   public String getUsername()
   {
	   return username;
   }
    /**
     * shows what the user can do to std out
     * ie "press 1 to add publication"
     */
    public abstract void showOptions();
    
}
