import java.util.ArrayList;
import java.util.Scanner;

	public class RentalSystem {
		
	    // instance variables to hold information about the book
	    private String title; 
	    private String author; 
	    private int copies; 
	
	   //a constructor to initialize the fields of BookRentalSystem object
	    public RentalSystem(String title, String author, int copies) {
	    	
	        this.title = title;
	        this.author = author;
	        this.copies = copies;
	    }
	
	   //method to display book information
	    public void displayInfo() {
	    	
	        System.out.println("Book Title: " + title);
	        System.out.println("Author Name: " + author);
	        System.out.println("Copies available: " + copies);
	        
	    }
	
	    
	    public int getCopies() {
	        return copies;
	    }
	    
	  
	    public void decrementCopies() {
	        copies--;
	    }
	    
	
	    public String getTitle() {
	        return title;
	    }
	    
	    
	    private String getAuthor() {
			return author;
		}
    
	    public static void runRentalSystem() { 
    	
	    ArrayList<RentalSystem> books = new ArrayList<>();
	       
        RentalSystem book1 = new RentalSystem("Don Quixote", "Miguel de Cervantes",3);
        RentalSystem book2 = new RentalSystem("Lord of the Rings", "J.R.R. Tolkien",2);
        RentalSystem book3 = new RentalSystem("And Then There Were None", "Agatha Christie",1);

    
        
        books.add(book1);
        books.add(book2);
        books.add(book3);

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n RENTAL SYSTEM");
        System.out.println("═════════════════════════════════════════════");
        
        do {
        	
            
            System.out.println("\nSelect a book to borrow by entering the corresponding index:");

            for (int i = 0; i < books.size(); i++) {
                System.out.println(i + ". " + books.get(i).getTitle() + ", " + books.get(i).getAuthor());
            }
            
            
            System.out.println("\n═════════════════════════════════════════════");
            int selectedIndex = scanner.nextInt();
            System.out.println(" ");

            
            if (selectedIndex < 0 || selectedIndex >= books.size()) {
                System.out.println("INDEX DOES NOT EXIST, Try Again!");
               
            } else {
            	
                RentalSystem selectedBook = books.get(selectedIndex);
                
                if (selectedBook.getCopies() > 0) {
                	
                    selectedBook.decrementCopies();
                    System.out.println("Book '"+ selectedBook.getTitle() + "' borrowed successfully!");
                    System.out.println("═════════════════════════════════════════════");
                    
                } else { 
                    System.out.println("No copies available.");
                }
            }
            
            System.out.println("\nWould you like to rent another book? (yes/no)");
            String rentAgain = scanner.next();

            if (rentAgain.equalsIgnoreCase("no")) {
                break;
            }

        } while (!books.isEmpty());

        scanner.close();

        System.out.println("═════════════════════════════════════════════");
        System.out.println("Exiting Rental System . . .");
        
    }


	public static void main(String[] args) {
    	
        runRentalSystem(); 
        
    }
}
