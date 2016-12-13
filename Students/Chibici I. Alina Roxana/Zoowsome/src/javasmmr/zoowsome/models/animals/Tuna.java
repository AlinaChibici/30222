package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.time.LocalDateTime;
import javasmmr.zoowsome.services.factories.Constants;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Tuna extends Aquatic{
	
	//constructors
	public Tuna(){
		this (1000, typesOfWater.SALTWATER, "Tuna", 0, 0.8, 0.0);
	}
	
	public Tuna(int avgSwimDepth, typesOfWater waterType, String name, int nrOfLegs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		super.setAvgSwimDepth(avgSwimDepth);
		super.setWaterType(waterType);
		super.setNrOfLegs(nrOfLegs);
		super.setName(name);
	}
	
	//methods
	@Override
	public double getPredisposition(){
		int dayOfMonth = LocalDateTime.now().getDayOfMonth();
		if (dayOfMonth >= 3 && dayOfMonth <= 10){
			return 0.15;
		}
		else {
			return 0.0;
		}
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml (eventWriter);
		createNode (eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animal.Aquatic.TUNA);
	}
}

