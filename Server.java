package ENSF480_TermProject;

public class Server {
    private static Server instance;
    
    
    public Server getInstance(){
        if(instance != null){
            instance = new Server();
        }
        return instance;
    }
    
}
