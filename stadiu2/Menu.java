package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	private static Scanner scanner = new Scanner(System.in);
    private static final ConfiguredLogger logger = new ConfiguredLogger();
    
	public static void main(String[] args) {
        int choice = -1;
        while (choice != 8) {
            displayMenu();
            choice = getUserChoice();
            handleChoice(choice);
        }
        scanner.close();
	}
    
    private static void displayMenu() {
        logger.info("Choose an action by pressing the corresponding key:");
        logger.info("\t1. Add a book");
        logger.info("\t2. Update a book");
        logger.info("\tSearch a book:");
        logger.info("\t\t3. by author");
        logger.info("\t\t4. by keywords");
        logger.info("\t\t5. by year");
        logger.info("\t\t6. by publisher");
        logger.info("\t\t7. by domain");
        logger.info("\t8. Quit");

        logger.info("Choose an action: ");
    }
    
    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            logger.info("Invalid input. Please enter a number.");
            scanner.next(); // consuma inputul invalid pt a evita o bucla infinita
        }
        return choice;
    }

    private static void handleChoice(int choice)
    {
		InsertOperation insertOp = new InsertOperation();
		SearchOperation searchOp = new SearchOperation();
		UpdateOperation updateOp = new UpdateOperation();
		
		String title = "";
		String author ="";
		String publisher = "";
		String[] keywords;
		String[] domains;
		int year = -1;
		
		String searchedAuthor = "";
		String searchedDomain = "";
		String searchedPublisher = "";
		int year1 = -1;
		int year2 = -1;
		
		String targetTitle = "";
		String targetAuthor = "";
		
		boolean okInput = false;
    	switch(choice)
		{
			case 1: 
				scanner.nextLine();
				logger.info("Title: ");
				title = scanner.nextLine();
				logger.info("Author: ");
				author = scanner.nextLine();
				logger.info("Keywords (separated by comma): ");
				keywords = scanner.nextLine().split(", ");
				
				okInput = false;
				while(!okInput)
				{
					boolean ok = true;
    		        try {
    		        	logger.info("Year: ");
        				year = scanner.nextInt();
    		        } catch (InputMismatchException e) 
    		        {
    		        	ok = false;
    		        	logger.info("Invalid input. Please enter an integer.");
    		            scanner.next();
    		        }
    		        if(ok)
    		        {
    		        	if(year > 0)
    		        	{
    		        		okInput = true;
    		        	}
    		        	else
    		        	{
    		        		logger.info("Please enter a positive number!");
    		        	}
    		        	
    		        }
				}
				scanner.nextLine();
				logger.info("Domains (separated by comma): ");
				domains = scanner.nextLine().split(", ");
				logger.info("Publisher: ");
				publisher = scanner.nextLine();
				insertOp.insertNewBook(title, author, keywords, year, domains, publisher);
				break;
			case 2: 
				scanner.nextLine();
				logger.info("Target title: ");
				targetTitle = scanner.nextLine();
				logger.info("Target author: ");
				targetAuthor = scanner.nextLine();
				
				logger.info("\n");

				logger.info("New title: ");
				title = scanner.nextLine();
				logger.info("New author: ");
				author = scanner.nextLine();
				logger.info("New keywords (separated by comma): ");
				keywords = scanner.nextLine().split(", ");
				okInput = false;
				while(!okInput)
				{
					boolean ok = true;
    		        try {
        				logger.info("New year: ");
        				year = scanner.nextInt();
    		        } catch (InputMismatchException e) 
    		        {
    		        	ok = false;
    		            logger.info("Invalid input. Please enter an integer.");
    		            scanner.next();
    		        }
    		        if(ok)
    		        {
    		        	if(year > 0)
    		        	{
    		        		okInput = true;
    		        	}
    		        	else
    		        	{
    		        		logger.info("Please enter a positive number!");
    		        	}
    		        	
    		        }
				}
				scanner.nextLine();
				logger.info("New domains (separated by comma): ");
				domains = scanner.nextLine().split(", ");
				logger.info("New publisher: ");
				publisher = scanner.nextLine();

				updateOp.updateBookByTitleAndAuthor(targetTitle, targetAuthor, title, author, keywords, year, domains, publisher);
				break;
			case 3: 
				scanner.nextLine();
				logger.info("Searched author: ");
				searchedAuthor = scanner.nextLine();
				searchOp.searchBooksByAuthor(searchedAuthor);
				break;
			case 4: 
				scanner.nextLine();
				logger.info("Searched keywords (separated by comma): ");
				keywords = scanner.nextLine().split(", ");
				searchOp.searchBooksByKeywords(keywords);
				break;
			case 5:
				okInput = false;
				while(!okInput)
				{
					boolean ok = true;
    		        try {
    		            logger.info("Year 1: ");
    		            year1 = scanner.nextInt();
    		            logger.info("Year 2: ");
    		            year2 = scanner.nextInt();
    		        } catch (InputMismatchException e) 
    		        {
    		        	ok = false;
    		            logger.info("Invalid input. Please enter integers.");
    		            scanner.next();
    		        }
    		        if(ok)
    		        {
    		        	if(year1 < 0 || year2 < 0)
    		        	{
    		        		logger.info("Please enter positive numbers!");
    		        	}
    		        	else
    		        	{
        		        	if(year1 > year2)
        		        	{
        		        		logger.info("Year 1 should be smaller than year 2!");
        		        	}
        		        	else
        		        	{
        		        		okInput = true;
        		        	}
    		        	}
    		        }
				}
				searchOp.searchBooksBetweenYears(year1, year2);
				break;
			case 6: 
				scanner.nextLine();
				logger.info("Searched publisher: ");
				searchedPublisher = scanner.nextLine();
				searchOp.searchBooksByPublisher(searchedPublisher);
				break;
			case 7: 
				scanner.nextLine();
				logger.info("Searched domain: ");
				searchedDomain = scanner.nextLine();
				searchOp.searchBooksByDomain(searchedDomain);
				break;
			case 8: break;
			default:break;
		}
    }
}
