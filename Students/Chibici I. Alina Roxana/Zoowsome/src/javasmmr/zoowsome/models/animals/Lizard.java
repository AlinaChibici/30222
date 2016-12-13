package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javasmmr.zoowsome.services.factories.Constants;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Lizard extends Reptile{
	
	//constructors
	public Lizard(){
		this (true, "Lizard", 4, 6.7, 0.2);	
	}
	
	public Lizard(Boolean laysEggs, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		super.setLaysEggs(laysEggs);
		super.setNrOfLegs(nrOfLegs);
		super.setName(name);
	}
	
	//methods
	@Override
	public double getPredisposition(){
		int month = LocalDateTime.now().getMonthValue();
		if (month == 9){
			return 0.15;
		}
		else {
			return 0.0;
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Reptile.LIZARD);
	}
}

