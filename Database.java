
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class Database {
    private ArrayList<Document> documents;
    private Scanner scan;
    private PrintWriter write;
    
    public Database(){
        documents = new ArrayList();
        File file = new File("Documents.txt"); 
        try {
            scan = new Scanner(file);
        } 
        catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
        initializeDatabase();
        scan.close();
        
    }
    
    public void initializeDatabase(){
        while(scan.hasNextLine()){
            String type = scan.next();
            String title = scan.next();
            String author = scan.next();
            int isbn = Integer.parseInt(scan.next());
            String path = scan.next();
            int stock = Integer.parseInt(scan.next());
            
            if(type.compareTo("B") == 0){
                Book book = new Book(title, author, path, stock);
                documents.add(book);
            }
            else if(type.compareTo("M") == 0){
                Magazine mag = new Magazine(title, author, path, stock);
                documents.add(mag);
            }
            else if(type.compareTo("J") == 0){
                Journal journal = new Journal(title, author, path, stock);
                documents.add(journal);
            }
        }
    }

    public ArrayList<Document> getDocuments() {
        return documents;
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
    
    
    /**
     * Main for testing
     * @param args 
     */
    public static void main(String[] args){
       Database db = new Database();
        System.out.println(db.getDocuments().size());
    }
}

