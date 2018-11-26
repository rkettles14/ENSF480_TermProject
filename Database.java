
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




public class Database {
    private ArrayList<Document> documents;
    private Scanner scan;
    private PrintWriter write;
    private File file;
    
    public Database(){
        documents = new ArrayList();
        file = new File("Documents.txt"); 
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
            title = title.replace('_', ' ');
            String author = scan.next();
            author = author.replace('_', ' ');
            double price = Double.parseDouble(scan.next());
            int isbn = Integer.parseInt(scan.next());
            String path = scan.next();
            int stock = Integer.parseInt(scan.next());
            
            if(type.compareTo("B") == 0){
                Book book = new Book(title, author, price, isbn, path, stock);
                documents.add(book);
            }
            else if(type.compareTo("M") == 0){
                Magazine mag = new Magazine(title, author, price, isbn, path, stock);
                documents.add(mag);
            }
            else if(type.compareTo("J") == 0){
                Journal journal = new Journal(title, author, price, isbn, path, stock);
                documents.add(journal);
            }
        }
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }
   
    public String docToString(Document d){
        String titleInFile = d.getTitle().replace(' ', '_');
        String authorInFile = d.getAuthorName().replace(' ', '_');
        String docString=("\n"+d.getType()+ "			" +titleInFile+"    " + authorInFile
                            + "      "+ d.getPrice() + "      " + d.getIsbn() + "    "+ d.getPath()+ "    "+ d.getStockCount() );
        return docString;
    }
    
    public void addDocument(Document d){
        documents.add(d);
        String newLine = docToString(d);
        try {
            write = new PrintWriter(new FileWriter(file, true));
            write.write(newLine);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        write.close();
    }
    
    public int removeDocument(int targetISBN){
        boolean isFound = false;
        for(int i = 0; i< documents.size(); i++){
            if(documents.get(i).getIsbn() == targetISBN){
                documents.remove(i);
                isFound = true;
            }
            
        }
        if(isFound == false){
            return -1;
        }
        writeListToFile();
        return 1;
    }
    
    public void writeListToFile(){
        String arr[] = new String[documents.size()];
        for(int i = 0; i< documents.size(); i++){
            String docString = docToString(documents.get(i));
            arr[i] = docString;          
        }
        arr[0] = arr[0].replaceFirst("\n", "");
        try {
            write = new PrintWriter(new FileWriter(file, false));
            for(int i = 0; i <documents.size(); i++){
                write.print(arr[i]);
                write.flush();
            }
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        write.close();
    }
    
    public Document searchForDocument(int targetISBN){
        Document d = null;
        for(int i = 0; i < documents.size(); i ++){
            if(documents.get(i).getIsbn() == targetISBN){
                d = documents.get(i);
                return d;
            }
        }
        
        System.out.println("Could not find document, sorry chef.");
        return d;
    }
        
    
    /**
     * Main for testing
     * @param args 
     */
    public static void main(String[] args){
       Database db = new Database();
        System.out.println(db.getDocuments().size());
//        Book d = new Book("New Title", "Rylan Kettles", "c:/myPath", 88);
//        db.addDocument(d);
        
    }
}

