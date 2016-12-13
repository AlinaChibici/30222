package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

public abstract class Mammal extends Animal{
	
	//attributes
	private float normalBodyTemp;
	private float percBodyHair;
	
	//constructor
	public Mammal(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
	}
	
	//methods
	public float getNormalBodyTemp() {
		return normalBodyTemp;
	}
	
	public void setNormalBodyTemp(float normalBodyTemp) {
		this.normalBodyTemp = normalBodyTemp;
	}
	
	public float getPercBodyHair() {
		return percBodyHair;
	}
	
	public void setPercBodyHair(float percBodyHair) {
		this.percBodyHair = percBodyHair;
	}
	
	@Override
	public double getPredisposition(){
		return super.getPredisposition();
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode (eventWriter, "normalBodyTemp", String.valueOf(getNormalBodyTemp()));
		createNode (eventWriter, "percBodyHair", String.valueOf(getPercBodyHair()));
	}
	
	@Override
	public void decodeFromXml (Element element){
		setNormalBodyTemp (Float.valueOf(element.getElementsByTagName("normalBodyTemp").item(0).getTextContent()));
		setPercBodyHair (Float.valueOf(element.getElementsByTagName("percBodyHair").item(0).getTextContent()));
	}
}
