package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javasmmr.zoowsome.services.factories.Constants;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Snake extends Reptile{
	
	//constructors
	public Snake(){
		this (true, "Snake", 0, 1.5, 0.7);
	}
	
	public Snake(Boolean laysEggs, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		super.setLaysEggs(laysEggs);
		super.setNrOfLegs(nrOfLegs);
		super.setName(name);
	}
	
	//methods
	@Override
	public double getPredisposition(){
		int month = LocalDateTime.now().getMonthValue();
		if (month < 3){
			return 0.2;
		}
		else {
			return 0.0;
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Reptile.SNAKE);
	}
}
