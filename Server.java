public class Server {
    private static Server instance;
    
    private Server(){
        
    }
    
    
    public Server getInstance(){
        if(instance != null){
            instance = new Server();
        }
        return instance;
    }
    
}
