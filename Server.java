import java.util.Vector;
public class Server {
	
    private static Server instance;
    public 
    
    private Server()
    {
    	
    }
    
    private Server(Server src)
    {
    	this.users = src.users;
    	
    }
    
    public Server getInstance(){
        if(instance != null){
            instance = new Server();
        }
        return instance;
    }
    
}
