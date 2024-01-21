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
	
	public XMLDocument()
	{
        try {
        	//se creeaza o instanta a cls DocumentBuilderFactory
        	//DocumentBuilder e fol pt a parcurge fisiere xml si pt a crea ob. Document
        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        	factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            //document este continutul fisierului xml
            document = builder.parse(new File(filePath));
          //se asigura ca doc. este consistent si usor pt a lucra cu el
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
