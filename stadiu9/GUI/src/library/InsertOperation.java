package library;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

//clasa pt gestiona operatia de adaugare a unei carti in fisierul xml
public class InsertOperation extends ConcreteOperation{

	//pt a introduce o noua carte in xml
    public String insertNewBook(String title, String author, 
    		String[] keywords, int year, String[] domains, String publisher) {
    	
    	try {
    		//daca acea carte e deja in xml
        	if(bookExists(title, author))
        	{
        		return "Book already exists!";
        	}
        	else
        	{
        		//obtine documentul xml si radacina 
        		Document document = xmlDocument.getDocument();
        		Element root = document.getDocumentElement();

                // se creeaza un nou element de tip book
                Element newBook = document.createElement("book");
                
                //se creeaza elementele pt toate datele cartii si se seteaza continutul lor

                Element titleElement = document.createElement("title");
                titleElement.setTextContent(title);

                Element authorsElement = document.createElement("author");
                authorsElement.setTextContent(author);
                
                //cuv cheie sunt siruri de caractere separate prin virgula
                Element keywordsElement = document.createElement("keywords");
                keywordsElement.setTextContent(String.join(", ", keywords));
                
                // pt an, se transforma mai intai intregul la string
                Element yearElement = document.createElement("year");
                yearElement.setTextContent(Integer.toString(year));
                
                //domeniile sunt siruri de caractere separate prin virgula
                Element domainsElement = document.createElement("domains");
                domainsElement.setTextContent(String.join(", ", domains));

                Element publisherElement = document.createElement("publisher");
                publisherElement.setTextContent(publisher);

                //se ataseaza elementele componente la noua carte creata
                newBook.appendChild(titleElement);
                newBook.appendChild(authorsElement);
                newBook.appendChild(yearElement);
                newBook.appendChild(keywordsElement);
                newBook.appendChild(domainsElement);
                newBook.appendChild(publisherElement);

                // se adauga noua carte la xml
                root.appendChild(newBook);
                
                //se salveaza schimbarile facute
                saveDocument();
                return "Book has been added successfully!";
        	}
            
        }catch(Exception e)
        {
        	return "Insertion Error!!!";
        }
    }
    
}