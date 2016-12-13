package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javasmmr.zoowsome.services.factories.Constants;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Tiger extends Mammal{
	
	//constructors
	public Tiger(){
		this ( (float)37.5, 95, "Tiger", 4, 4.5, 0.9);	
	}
	
	public Tiger(float normalBodyTemp, float percBodyHair, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
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
		if (hour >= 16 && hour <= 17){
			return -0.6; //after feeding
		}
		else {
			return 0.0;
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Mammal.TIGER);
	}
}

