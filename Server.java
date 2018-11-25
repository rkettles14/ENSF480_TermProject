import java.util.Vector;
import java.util.Scanner;

public class Server {
	
    private static Server instance;
    public Vector<User> users;
    
    private Server()
    {
    	
    }
    
    private Server(Server src)
    {
    	this.users = src.users;
    	this.instance = src.instance;
    }
    
    public User validate(String username, String password)
    {
    	for(int i = 0; i < users.size(); i++)
    	{
    		if(username == users.get(i).getUsername())
    			if(password == users.get(i).getPassword())
    				return users.get(i);
    	}
    	return null;
    }
    
    public void add(User user)
    {
    	users.add(user);
    }
    
    public static Server getInstance(){
    
        if(instance != null){
        	
            instance = new Server();
        }
        return instance;
    }
    
    public static void main(String [] args)
    {
    	Scanner stdin = new Scanner(System.in);
    	User startup = new Opener();
    	System.out.println("Welcome to the sunshine tropical paradise of Isle Delfino"
    			+ "\nNew user or existing? type (1/2)");
    	int i = stdin.nextInt();
    		while(i !=1 && i != 2) {
    		System.out.println("Listen to me you cunt bitch, \nNew user or existing? (1/2)");
    		i = stdin.nextInt();
    		}
    	System.out.println("there ya fucken go");
    }
}
