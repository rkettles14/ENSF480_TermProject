
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
        System.out.println("Updating document " + targetISBN + ".");
        Document d = instance.database.getDocument(targetISBN);
        String input = stdin.nextLine();
        if(d == null){
            System.out.println("Sorry, no document with that ISBN exists.");
            return;
        }
        System.out.println("Would you like to change the Author's name? Y/N");
        input = stdin.nextLine();
        System.out.println(input);
        if(input.matches("Y")){
            System.out.println("What would you like to change their name to?");
            input = stdin.nextLine();
            d.setAuthorName(input);
        }
        
        System.out.println("Would you like to change the path to the document?");
        input = stdin.nextLine();
        if(input.matches("Y")){
            System.out.println("What would you like to change the path to?");
            input = stdin.nextLine();
            d.setPath(input);
        }
        
        System.out.println("Would you like to change the current stock of the Document?");
        input = stdin.nextLine();
        if(input.matches("Y")){
            System.out.println("What is the new stock of the document?");
            int inputInt = stdin.nextInt();
            d.setStockCount(inputInt);
        }
        
        System.out.println("Document has been updated. Displaying new values of document");
        d.display();
    }
    @Override
    public void showOptions() {
        stdin.reset();
        System.out.println("Press 1 to add document.");
        System.out.println("Press 2 to remove document.");
        System.out.println("Press 3 to update document.");
        
        
        while(true){
            String input = stdin.nextLine();
        
            if(input.matches("1")){
                addDocument();
                break;
                //call add
            }
            else if(input.matches("2")){
                System.out.println("Type the ISBN of the document you would like to remove.");
                int inputInt = stdin.nextInt();
                instance.database.removeDocument(inputInt);
                break;
                //call remove

            }
            else if(input.matches("3")){
                System.out.println("Please type the ISBN of the document that you would like to update.");
                int inputInt = stdin.nextInt();
                updateDocument(inputInt);
                break;
            }
            else{
                System.out.println("invalid input.");
            }
        }
        stdin.reset();
        showOptions();
    }
    
}
