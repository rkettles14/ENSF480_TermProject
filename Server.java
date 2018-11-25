import java.util.Vector;
import java.util.Scanner;

public class Server {
	
    private static Server instance;
    public Vector<User> users;
    public Database database;
    private Server()
    {
    	users = new Vector<User>();
        database = new Database();
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
    	System.out.println("Invalid Username/Password");
    	return null;
    }
    
    public void add(User user)
    {
    	users.add(user);
    }
    
    public static Server getInstance(){
        if(instance == null){
        	
            instance = new Server();
        }
        return instance;
    }
    
    public static void main(String [] args)
    {
    	String username;
    	String password;
    	int choice = 0;
    	User user;
    	
    	Scanner stdin = new Scanner(System.in);
    	//PROGRAM START
    	System.out.println("Welcome to the sunshine tropical paradise of Isle Delfino"
    			+ "\n all inputs and options will be dealt with by entering a number to select an option unless otherwise stated...");
    	//INITIAL OPTIONS
    		choice = loopForInput(2,  "Please select a User type:"
    				+ "\nRegistered Buyer (1)"
    				+ "\nOperator (2)"
    				+ "\nSystemAdmin (3)"
    				+ "\nManager (4)"
    				+ "\nAuthor (5)"
    				+ "\nBuyer (6)");
    		
    	if(choice == 1) {
    		
    	}
    	
    	else if(choice == 2) {
    		User user = new Operator();
    	}

    	else if(choice == 3) {
    		
    	}

    	else if(choice == 4) {
    		
    	}

    	else if(choice == 5) {
    		
    	}

    	else if(choice == 6) {
    		User user = new Buyer();
    	}
    	
    	user.showOptions();
    	
    }
}

public static int loopForInput(int max, String str)
{
	Scanner stdin1 = new Scanner(System.in);
	int i;
	do {
		System.out.println(str);
		i = stdin1.nextInt();
	}while(i > max);
	
	return i;
}
