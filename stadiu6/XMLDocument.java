package library;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

//clasa pt a gestiona documentul xml
//vazuta ca o clasa Singleton
public class XMLDocument {
	//documentul XML (continutul lui)
	private Document document;
	//locatia documentului
	private String filePath = "C:\\Users\\ASUS\\Desktop\\master1\\MSIC\\Proiect\\library\\src\\library\\library_xml.xml";
	
	//instanta clasei (caracteristica Singleton)
	private static XMLDocument instance = null;
	
	public XMLDocument() {
	    try {
	        // Use static access for DocumentBuilderFactory
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
	        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

	        DocumentBuilder builder = factory.newDocumentBuilder();
	        document = builder.parse(new File(filePath));

	        // Ensure that the document is consistent and easy to work with
	        document.getDocumentElement().normalize();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	//pt a putea obtine instanta clasei
	public static XMLDocument getInstance()
	{
		//daca nu a fost creata nicio instanta a XMLDocument => se creeaza
		if(instance == null)
		{
			instance = new XMLDocument();
		}
		//se returneaza instanta nou creata sau deja existenta
		return instance;
	}

	//getteri pentru datele membru ale clasei
	public Document getDocument() {
		return document;
	}

	public String getFilePath() {
		return filePath;
	}
}
