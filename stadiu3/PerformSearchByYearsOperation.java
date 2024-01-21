package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PerformSearchByYearsOperation implements PerformOperation {
	private static Scanner scanner = new Scanner(System.in);
    private static final ConfiguredLogger logger = new ConfiguredLogger();
	@Override
	public void performOperation() {
		SearchOperation searchOp = new SearchOperation();

		int year1 = -1;
		int year2 = -1;
		
		boolean okInput = false;
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

	}

}
