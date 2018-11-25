
import java.util.ArrayList;


public class Database {
    private ArrayList<Document> documents;
    public Database(){
        documents = new ArrayList<Document>();
    }
    
    public void addDocument(Document d){
        documents.add(d);
        System.out.println("Document added");
        System.out.println("The ISBN of the document added is " + d.getIsbn());
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
    
    //This is all we need in order to be able to update documents.
    //The actual updating can be done on my end in Operator. ~Z
    public Document getDocument(int targetISBN){
        Document d = null;
        for(int i = 0; i < documents.size(); i ++){
            if(documents.get(i).getIsbn() == targetISBN){
                d = documents.get(i);
                return d;
            }
        }
        
        System.out.println("Coulnd not find document, sorry chef.");
        return d;
    }
    
}

