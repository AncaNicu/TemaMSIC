package library;

import java.util.Scanner;

public class PerformSearchByDomainOperation implements PerformOperation {
	private static Scanner scanner = new Scanner(System.in);
    private static final ConfiguredLogger logger = new ConfiguredLogger();
	@Override
	public void performOperation() {
		SearchOperation searchOp = new SearchOperation();

		String searchedDomain = "";
		
		scanner.nextLine();
		logger.info("Searched domain: ");
		searchedDomain = scanner.nextLine();
		searchOp.searchBooksByDomain(searchedDomain);
	}

}
