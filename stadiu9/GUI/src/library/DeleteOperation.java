package library;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//clasa pt stergerea unei carti
public class DeleteOperation extends ConcreteOperation {

	//fct pt stergerea unei carti
    public String deleteBook(String title, String author) {

        try {
            //verifica daca cartea exista
            if (!bookExists(title, author)) {
                return "Book does not exist!";
            } else {
            	//exista => obtine documentul XML
                var document = xmlDocument.getDocument();
                var root = document.getDocumentElement();

                //parcurge toate cartile din XML
                NodeList bookList = root.getElementsByTagName("book");
                for (int i = 0; i < bookList.getLength(); i++) {
                    Node bookNode = bookList.item(i);
                    if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element bookElement = (Element) bookNode;
                        String currentTitle = getElementValue(bookElement, "title");
                        String currentAuthor = getElementValue(bookElement, "author");

                        //cartea crt este cartea de sters => se sterge din XML si se salveaza documentul
                        if (currentTitle.equals(title) && currentAuthor.equals(author)) {
                            root.removeChild(bookNode);
                            saveDocument(); //salveaza schimbarile in XML
                            return "Book has been deleted successfully!";
                        }
                    }
                }
            }

        } catch (Exception e) {
            return "Deletion Error: " + e.getMessage();
        }
		return "";
    }

    //fct ajutatoare pt a obtine continutul text al unui element
    private String getElementValue(Element parentElement, String elementName) {
        NodeList nodeList = parentElement.getElementsByTagName(elementName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }
}
