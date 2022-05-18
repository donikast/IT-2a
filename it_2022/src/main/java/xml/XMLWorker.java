package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import repositories.Repository;

public class XMLWorker {
	
	public void writeInXMLFile(String pathToXmlFile, Repository collection) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(Repository.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(collection, new File(pathToXmlFile));
	}
	
	public Repository readFromXmlFile(String pathToXmlFile, String pathToSchema) throws JAXBException, FileNotFoundException, UnsupportedEncodingException, SAXException {
		JAXBContext context = JAXBContext.newInstance(Repository.class);
		Unmarshaller um = context.createUnmarshaller();
		
		InputStream inputStream = new FileInputStream(pathToXmlFile);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File(pathToSchema));
		um.setSchema(schema);
		
		Repository collection = (Repository) um.unmarshal(reader);
		return collection;
	}

}
