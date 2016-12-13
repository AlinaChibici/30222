package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Insect extends Animal{
	
	//attributes
	private Boolean canFly;
	private Boolean isDangerous;
	
	//constructor 
	public Insect(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
	}
	
	//methods
	public Boolean getCanFly() {
		return canFly;
	}
	
	public void setCanFly(Boolean canFly) {
		this.canFly = canFly;
	}
	
	public Boolean getIsDangerous() {
		return isDangerous;
	}
	
	public void setIsDangerous(Boolean isDangerous) {
		this.isDangerous = isDangerous;
	}
	
	@Override
	public double getPredisposition(){
		return super.getPredisposition();
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode (eventWriter, "canFly", String.valueOf(getCanFly()));
		createNode (eventWriter, "isDangerous", String.valueOf(getIsDangerous()));
	}
	
	@Override
	public void decodeFromXml (Element element){
		setCanFly (Boolean.valueOf(element.getElementsByTagName("canFly").item(0).getTextContent()));
		setIsDangerous (Boolean.valueOf(element.getElementsByTagName("isDangerous").item(0).getTextContent()));
	}
}
