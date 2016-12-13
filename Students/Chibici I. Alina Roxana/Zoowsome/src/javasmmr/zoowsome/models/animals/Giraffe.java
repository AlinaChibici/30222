package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javasmmr.zoowsome.services.factories.Constants;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Giraffe extends Mammal{
	
	//constructors
	public Giraffe(){
		this ( (float)38.5, 95, "Giraffe", 4, 5.6, 0.2);
	}
	
	public Giraffe(float normalBodyTemp, float percBodyHair, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		super.setNormalBodyTemp(normalBodyTemp);
		super.setPercBodyHair(percBodyHair);
		super.setNrOfLegs(nrOfLegs);
		super.setName(name);	
	}
	
	//methods
	@Override
	public double getPredisposition(){
		int period = LocalDateTime.now().getDayOfMonth();
		if (period > 14 && period < 20){
			return 0.2;
		}
		else {
			return 0.0;
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Mammal.GIRAFFE);
	}
}
