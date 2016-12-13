package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Bird extends Animal{
	
	//attributes
	private Boolean migrates;
	private int avgFlightAltitude;
	
	//constructor
	public Bird(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
	}
	
	//methods
	public int getAvgFlightAltitude() {
		return avgFlightAltitude;
	}
	
	public void setAvgFlightAltitude(int avgFlightAltitude) {
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public Boolean getMigrates() {
		return migrates;
	}
	
	public void setMigrates(Boolean migrates) {
		this.migrates = migrates;
	}
	
	@Override
	public double getPredisposition(){
		return super.getPredisposition();
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode (eventWriter, "migrates", String.valueOf(getMigrates()));
		createNode (eventWriter, "avgFlightAltitude", String.valueOf(getAvgFlightAltitude()));
	}
	
	@Override
	public void decodeFromXml (Element element){
		setMigrates (Boolean.valueOf(element.getElementsByTagName("migrates").item(0).getTextContent()));
		setAvgFlightAltitude (Integer.valueOf(element.getElementsByTagName("avgFlightAltitude").item(0).getTextContent()));
	}
}
