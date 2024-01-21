package library;

import java.util.Scanner;

public class PerformSearchByKeywordsOperation implements PerformOperation {
	private static Scanner scanner = new Scanner(System.in);
    private static final ConfiguredLogger logger = new ConfiguredLogger();
	@Override
	public void performOperation() {
		SearchOperation searchOp = new SearchOperation();

		String[] keywords;

		scanner.nextLine();
		logger.info("Searched keywords (separated by comma): ");
		keywords = scanner.nextLine().split(", ");
		searchOp.searchBooksByKeywords(keywords);
	}

}
