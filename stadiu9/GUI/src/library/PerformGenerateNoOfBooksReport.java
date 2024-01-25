package library;
//clasa care se ocupa cu generarea efectiva a raportului cu nr de carti
public class PerformGenerateNoOfBooksReport implements PerformOperation {

	@Override
	public String performOperation() {
		GenerateNoOfBooksReport report = new GenerateNoOfBooksReport();
		//se genereaza raportul si se afiseaza rezultatul
		report.generateReport();
		return "There are " + report.getNoOfBooks() + " books in the library.";
	}

}
