package javasmmr.zoowsome.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javasmmr.zoowsome.models.animals.*;
import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javasmmr.zoowsome.services.factories.Constants;

public class AnimalRepository {
	
	private static final String XML_FILENAME = "Animals.xml";
	
	public AnimalRepository (){}
	
	public void save (ArrayList<Animal> animals) throws FileNotFoundException, XMLStreamException {
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		//Create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream (XML_FILENAME));
		//Create a EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		//Create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		// Create content open tag
		StartElement configStartElement = eventFactory.createStartElement ("", "", "content");
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		
		for (XML_Parsable animal : animals){
			StartElement sElement = eventFactory.createStartElement ("", "", Constants.XML_TAGS.ANIMAL);
			eventWriter.add(sElement);
			eventWriter.add(end);
			
			animal.encodeToXml (eventWriter);
			
			EndElement eElement = eventFactory.createEndElement ("", "", Constants.XML_TAGS.ANIMAL);
			eventWriter.add(eElement);
			eventWriter.add(end);	
		}
		
		eventWriter.add (eventFactory.createEndElement ("", "", "content"));
		eventWriter.add (eventFactory.createEndDocument());
		eventWriter.close();
		
	}
	
	public ArrayList<Animal> load() throws ParserConfigurationException, SAXException, IOException {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		File fXmlFile = new File (XML_FILENAME);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
		NodeList nodeList = doc.getElementsByTagName(Constants.XML_TAGS.ANIMAL);
		
		for (int i = 0; i < nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) node;
				String discriminant = element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
				switch (discriminant){
					
					case Constants.Animal.Aquatic.CLOWNFISH: 
						Animal clownfish = new Clownfish();
						clownfish.decodeFromXml(element);
						animals.add (clownfish);
					
					case Constants.Animal.Aquatic.PIRANHA: 
						Animal piranha = new Piranha();
						piranha.decodeFromXml(element);
						animals.add (piranha);
					
					case Constants.Animal.Aquatic.TUNA: 
						Animal tuna = new Tuna();
						tuna.decodeFromXml(element);
						animals.add (tuna);
				
					case Constants.Animal.Insect.BUTTERFLY: 
						Animal butterfly = new Butterfly();
						butterfly.decodeFromXml(element);
						animals.add (butterfly);
					
					case Constants.Animal.Insect.MOSQUITO: 
						Animal mosquito = new Mosquito();
						mosquito.decodeFromXml(element);
						animals.add (mosquito);
					
					case Constants.Animal.Insect.SPIDER: 
						Animal spider = new Spider();
						spider.decodeFromXml(element);
						animals.add (spider);
					
					case Constants.Animal.Bird.EAGLE: 
						Animal eagle = new Eagle();
						eagle.decodeFromXml(element);
						animals.add (eagle);
					
					case Constants.Animal.Bird.PARROT: 
						Animal parrot = new Parrot();
						parrot.decodeFromXml(element);
						animals.add (parrot);
					
					case Constants.Animal.Bird.SWAN: 
						Animal swan = new Swan();
						swan.decodeFromXml(element);
						animals.add (swan);
					
					case Constants.Animal.Mammal.GIRAFFE: 
						Animal giraffe = new Giraffe();
						giraffe.decodeFromXml(element);
						animals.add (giraffe);
					
					case Constants.Animal.Mammal.LION: 
						Animal lion = new Lion();
						lion.decodeFromXml(element);
						animals.add (lion);
					
					case Constants.Animal.Mammal.TIGER: 
						Animal tiger = new Tiger();
						tiger.decodeFromXml(element);
						animals.add (tiger);
					
					case Constants.Animal.Reptile.LIZARD: 
						Animal lizard = new Lizard();
						lizard.decodeFromXml(element);
						animals.add (lizard);
					
					case Constants.Animal.Reptile.SNAKE: 
						Animal snake = new Snake();
						snake.decodeFromXml(element);
						animals.add (snake);
					
					case Constants.Animal.Reptile.TORTOISE: 
						Animal tortoise = new Tortoise();
						tortoise.decodeFromXml(element);
						animals.add (tortoise);
					
					default: 
						break;
				}
			}
		}
		return animals;	
	}
	
	public static void createNode (XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// Create Start node
		StartElement sElement = eventFactory.createStartElement ("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// Create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// Create End node
		EndElement eElement = eventFactory.createEndElement ("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);	
	}		
}
