
/**
 *
 * @author Rylan, Zach, Brandon
 */
public class Operator extends User{

    public Operator(){
        super();
        
    }
    
    public void addDocument(){
        System.out.println("What kind of document would you like to add\n");
        System.out.println("Type 'J' for Journal, 'B' for Book, or 'M' for Magazine\n");
        boolean goodInput = false;
        while(!goodInput){
            String input = stdin.nextLine();
            if(input.compareTo("J") == 0){
                System.out.println("Lets make a Journal");
                addJournal();
                goodInput = true;
            }
            else if(input.compareTo("B") == 0){
                System.out.println("Lets make a Book");
                addBook();
                goodInput = true;
            }
            else if(input.compareTo("M") == 0){
                System.out.println("Lets make a Magazine");
                addMagazine();
                goodInput = true;
            }
            else {
                System.out.println("Sorry, could not read that. Please try again.");
            }
        }
    }
    
    public void addJournal(){
        
        System.out.println("What is the author of your Journal?");
        String author = stdin.nextLine();
        
        System.out.println("What is the filepath of your Journal?");
        String filepath = stdin.nextLine();
        
        System.out.println("What is the initial stock of your Journal?");
        int stock = stdin.nextInt();
        
        Journal journal = new Journal(author, filepath, stock);
        
        System.out.println("Made a journal, lets see if I did tho");
        instance.database.addDocument(journal);
        journal.executeStrategy();
        
    }
    
    public void addBook(){

        System.out.println("What is the author of your Book?");
        String author = stdin.nextLine();
        
        System.out.println("What is the filepath of your Book?");
        String filepath = stdin.nextLine();
        
        System.out.println("What is the initial stock of your Book?");
        int stock = stdin.nextInt();
        
        Book book = new Book(author, filepath, stock);
        
        System.out.println("Made a book, lets see if I did tho");
        instance.database.addDocument(book);
        book.executeStrategy();
    }
    
    public void addMagazine(){
       
        System.out.println("What is the author of your Magazine?");
        String author = stdin.nextLine();
        
        System.out.println("What is the filepath of your Magazine?");
        String filepath = stdin.nextLine();
        
        System.out.println("What is the initial stock of your Magazine?");
        int stock = stdin.nextInt();
        
        Magazine magazine = new Magazine(author, filepath, stock);
        
        System.out.println("Made a magazine, lets see if I did tho");
        instance.database.addDocument(magazine);
        magazine.executeStrategy();
        
    }
    
    public void updateDocument(int targetISBN){
        
    }
    @Override
    public void showOptions() {
        System.out.println("Press 1 to add document.");
        System.out.println("Press 2 to remove document.");
        System.out.println("Press 3 to update document.");
        
        
        while(true){
            int i = stdin.nextInt();
        
            if(i == 1){
                addDocument();
                break;
                //call add
            }
            else if(i == 2){
                System.out.println("Type the ISBN of the document you would like to remove.");
                int inputInt = stdin.nextInt();
                break;
                //call remove

            }
            else if(i == 3){
                System.out.println("implement later");
                break;
                //call update
            }
            else{
                System.out.println("invalid input.");

            }
            stdin.close();
        }
        
    }
    
}
