package library;

import java.util.Scanner;

public class PerformSearchByPublisherOperation implements PerformOperation {
	private static Scanner scanner = new Scanner(System.in);
    private static final ConfiguredLogger logger = new ConfiguredLogger();
	@Override
	public void performOperation() {
		SearchOperation searchOp = new SearchOperation();
		
		String searchedPublisher = "";

		scanner.nextLine();
		logger.info("Searched publisher: ");
		searchedPublisher = scanner.nextLine();
		searchOp.searchBooksByPublisher(searchedPublisher);
	}

}
