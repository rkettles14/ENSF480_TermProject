
import java.util.ArrayList;


public class Database {
    private ArrayList<Document> documents;
    public Database(){
        documents = new ArrayList<Document>();
    }
    
    public void addDocument(Document d){
        documents.add(d);
        System.out.println("Document added");
    }
    
    public void removeDocument(int targetISBN){
        for(int i = 0; i< documents.size(); i++){
            if(documents.get(i).getIsbn() == targetISBN){
                documents.remove(i);
                System.out.println("Document Removed");
                return;
            }
            
        }
        
        System.out.println("Could not find document, sorry chef.");
    }
    
    
    //Todo updateDoc()?????
    
}

