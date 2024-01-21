package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PerformInsertOperation implements PerformOperation{
	private static Scanner scanner = new Scanner(System.in);
    private static final ConfiguredLogger logger = new ConfiguredLogger();
	@Override
	public void performOperation() {
		InsertOperation insertOp = new InsertOperation();
		
		String title = "";
		String author ="";
		String publisher = "";
		String[] keywords;
		String[] domains;
		int year = -1;
		
		boolean okInput = false;
		
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
	}

}
