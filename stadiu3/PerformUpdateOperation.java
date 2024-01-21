package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PerformUpdateOperation implements PerformOperation{
	private static Scanner scanner = new Scanner(System.in);
    private static final ConfiguredLogger logger = new ConfiguredLogger();
	@Override
	public void performOperation() {
		UpdateOperation updateOp = new UpdateOperation();
		
		String title = "";
		String author ="";
		String publisher = "";
		String[] keywords;
		String[] domains;
		int year = -1;
		
		String targetTitle = "";
		String targetAuthor = "";
		
		boolean okInput = false;
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

	}

}
