package library;
//clasa care se ocupa cu generarea efectiva a raportului cu nr de autori
public class PerformGenerateNoOfAuthorsReport implements PerformOperation {

	@Override
	public String performOperation() {
		GenerateNoOfAuthorsReport report = new GenerateNoOfAuthorsReport();
		//se genereaza raportul si se afiseaza rezultatul
		report.generateReport();
		return "There are " + report.getNoOfAuthors() + " authors.";
	}

}
