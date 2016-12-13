package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javasmmr.zoowsome.services.factories.Constants;

public class Butterfly extends Insect{
	
	//constructors
	public Butterfly(){
		this (true, false, "Butterfly", 6, 0.9, 0.0);
	}
	
	public Butterfly(Boolean canFly, Boolean isDangerous, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
		super (maintenanceCost, dangerPerc);
		super.setCanFly(canFly);
		super.setIsDangerous(isDangerous);
		super.setNrOfLegs(nrOfLegs);
		super.setName(name);
	}
	
	//methods
	@Override
	public double getPredisposition(){
		int month = LocalDateTime.now().getMonthValue();
		if (month > 9 && month < 12){
			return 0.1;
		}
		else {
			return 0.0;	
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Insect.BUTTERFLY);
	}
}
