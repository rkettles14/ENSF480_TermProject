import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Server {
	
    private static Server instance;
    public Vector<User> users;
    public Database database;
    public Scanner stdin;
    public static BuyerNotifier notifier;
    private Server()
    {
    	users = new Vector<User>();
        database = new Database();
        stdin = new Scanner(System.in);
        notifier = new BuyerNotifier();
    }
    
    private Server(Server src)
    {
    	this.users = src.users;
    	this.instance = src.instance;
    }

    public Database getDatabase() {
        return database;
    }
    
    
    
    public User validate(String username, String password)
    {
    	for(int i = 0; i < users.size(); i++)
    	{
    		if(username.equals(users.get(i).getUsername()))
    			if(password.equals(users.get(i).getPassword()))
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
    
    public static void main(String [] args) throws IOException
    {
    	

    	//BETTER IMPLEMENTATION OF SERVER WITH LOGIN
    	
        Server server = new Server();
    	int choice = 0;
    	User user;
    	
    	//SETUP
    	File file = new File("Users.txt");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while((st = br.readLine()) != null)
			{
				String[] parts = st.split("-");
				if(parts[0].equals("o"))
				{
					
					user = new Operator();
					user.setUsername(parts[1]);
					user.setPassword(parts[2]);
					server.users.add(user);
				}
				if(parts[0].equals("r"))
				{
					user = new RegisteredBuyer();
					user.setUsername(parts[1]);
					user.setPassword(parts[2]);
					server.users.add(user);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//PROGRAM START
    	System.out.println("Welcome to the sunshine tropical paradise of Isle Delfino"
    			+ "\n all inputs and options will be dealt with by entering a number to select an option unless otherwise stated...");
    	//INITIAL OPTIONS
    	
    	
    		choice = server.loopForInput(2,  "Please select an option:"
    				+ "\nView as Buyer (1)"
    				+ "\nLogin (2)");
    	//registered Buyer
    	if(choice == 1) {
    		user = new Buyer();
    	}
    	else if(choice == 2)
    	{
    		
    		System.out.println("Please enter your username:");
    		String username = server.stdin.next();
    		
    		
    		System.out.println("Please enter your password:");
    		String password = server.stdin.next();
    		
    		
    		user = server.validate(username, password);
    		
    		while(user == null)
    		{
    			System.out.println("Please enter your username:");
        		username = server.stdin.next();
        		
        		System.out.println("Please enter your password:");
        		password = server.stdin.next();
        		user = server.validate(username, password);
    		}
    	}
    	
    	else //SHOULD NEVER GET HERE
    		user = new Buyer();
    	
    	user.showOptions();
    
    	//////////////////////////////////////////////////////////////////////////////////
    	
    	//OLD VERSION OF SERVER
    	/*
    	String username;
    	String password;
        Server server = new Server();
    	int choice = 0;
    	User user;;
    	
    	//SETUP
    	//PROGRAM START
    	System.out.println("Welcome to the sunshine tropical paradise of Isle Delfino"
    			+ "\n all inputs and options will be dealt with by entering a number to select an option unless otherwise stated...");
    	//INITIAL OPTIONS
    	
    	
    		choice = server.loopForInput(6,  "Please select a User type:"
    				+ "\nRegistered Buyer (1)"
    				+ "\nOperator (2)"
    				+ "\nSystemAdmin (3)"
    				+ "\nManager (4)"
    				+ "\nAuthor (5)"
    				+ "\nBuyer (6)");
    	//registered Buyer
    	if(choice == 1) {
    		user = new Buyer();
    	}
    	//Operator
    	else if(choice == 2) {
    		user = new Operator();
    		
    	}
    	//System Admin
    	else if(choice == 3) {
    		user = new Buyer();
    	}
    	//Manager
    	else if(choice == 4) {
    		user = new Buyer();
    	}
    	//Author
    	else if(choice == 5) {
    		user = new Buyer();
    	}
    	//Buyer
    	else if(choice == 6) {
    		user = new Buyer();
    		
    	}
    	//should never get here
    	else 
    		user = new Buyer();
    	user.showOptions();
    */
    	
    }


public int loopForInput(int max, String str)
{
	int i;
	do {
		System.out.println(str);
		i = stdin.nextInt();
	}while(i > max);
	return i;
	
 }
}