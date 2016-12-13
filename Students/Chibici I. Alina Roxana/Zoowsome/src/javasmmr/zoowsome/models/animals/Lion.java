package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javasmmr.zoowsome.services.factories.Constants;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Lion extends Mammal{
	
	//constructors
	public Lion(){
		this( (float)38, 95, "Lion", 4, 4.5, 1.0);	
	}
	
	public Lion(float normalBodyTemp, float percBodyHair, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		super.setNormalBodyTemp(normalBodyTemp);
		super.setPercBodyHair(percBodyHair);
		super.setNrOfLegs(nrOfLegs);
		super.setName(name);
	}
	
	//methods
	@Override
	public double getPredisposition(){
		int hour = LocalDateTime.now().getHour();
		if (hour >= 12 && hour <= 14){
			return 0.1;
		}	
		else if (hour == 15){
			return -0.5; //Lion is sleeping
		}
		else {
			return 0.0;
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Mammal.LION);
	}
}

