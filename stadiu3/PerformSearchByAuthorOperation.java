package library;

import java.util.Scanner;

public class PerformSearchByAuthorOperation implements PerformOperation {

	private static Scanner scanner = new Scanner(System.in);
    private static final ConfiguredLogger logger = new ConfiguredLogger();
	@Override
	public void performOperation() {
		SearchOperation searchOp = new SearchOperation();
		
		String searchedAuthor = "";
		
		scanner.nextLine();
		logger.info("Searched author: ");
		searchedAuthor = scanner.nextLine();
		searchOp.searchBooksByAuthor(searchedAuthor);
	}

}
