package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javasmmr.zoowsome.services.factories.Constants;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Parrot extends Bird{
	
	//constructors
	public Parrot(){
		this( 97, false, "Parrot", 2, 2.8, 0.1);
	}
	
	public Parrot(int avgFlightAltitude, Boolean migrates, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		super.setAvgFlightAltitude(avgFlightAltitude);
		super.setMigrates(migrates);
		super.setNrOfLegs(nrOfLegs);
		super.setName(name);
	}
	
	//methods
	@Override
	public double getPredisposition(){
		int dayOfMonth = LocalDateTime.now().getDayOfMonth();
		if (dayOfMonth < 3){
			return 0.2;
		}
		else {
			return 0.0;
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Bird.PARROT);
	}
}
