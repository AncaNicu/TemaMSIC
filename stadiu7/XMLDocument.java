package library;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

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
	private String filePath; 
	
	//instanta clasei (caracteristica Singleton)
	private static XMLDocument instance = null;
	
	public XMLDocument(String filePath) {
	    try {
	        // Use static access for DocumentBuilderFactory
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
	        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

	        DocumentBuilder builder = factory.newDocumentBuilder();
	        document = builder.parse(new File(filePath));

	        // Ensure that the document is consistent and easy to work with
	        document.getDocumentElement().normalize();
	        this.filePath = filePath;
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
			Properties properties = new Properties();
			try (FileInputStream input = new FileInputStream("C:\\Users\\ASUS\\Desktop\\master1\\MSIC\\Proiect\\cuConfig\\src\\library\\config.properties")){
				properties.load(input);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
            String filePath = properties.getProperty("xml.file.path");

            instance = new XMLDocument(filePath);
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
