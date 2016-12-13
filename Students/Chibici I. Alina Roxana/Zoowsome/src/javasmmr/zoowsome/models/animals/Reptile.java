package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Reptile extends Animal{
	
	//attributes
	private Boolean laysEggs;

	//constructor
	public Reptile(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
	}
	
	//methods
	public Boolean getLaysEggs() {
		return laysEggs;
	}
	
	public void setLaysEggs(Boolean laysEggs) {
		this.laysEggs = laysEggs;
	}
	
	@Override
	public double getPredisposition() {
		return super.getPredisposition();
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode (eventWriter, "laysEggs", String.valueOf(getLaysEggs()));
	}
	
	@Override
	public void decodeFromXml (Element element){
		setLaysEggs (Boolean.valueOf(element.getElementsByTagName("laysEggs").item(0).getTextContent()));
	}
}
