package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javasmmr.zoowsome.services.factories.Constants;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Swan extends Bird{
	
	//constructors
	public Swan(){
		this (4000, true, "Swan", 2, 2.0, 0.2);	
	}
	
	public Swan(int avgFlightAltitude, Boolean migrates, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		super.setAvgFlightAltitude(avgFlightAltitude);
		super.setMigrates(migrates);
		super.setNrOfLegs(nrOfLegs);
		super.setName(name);
	}
	
	//methods
	@Override
	public double getPredisposition(){
		int dayOfYear = LocalDateTime.now().getDayOfYear();
		if(dayOfYear > 100 && dayOfYear < 150){
			return 0.2;
		}
		else {
			return 0.0;
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Bird.SWAN);
	}
}
