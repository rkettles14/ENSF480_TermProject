import java.util.Vector;
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
    	
    }
}
