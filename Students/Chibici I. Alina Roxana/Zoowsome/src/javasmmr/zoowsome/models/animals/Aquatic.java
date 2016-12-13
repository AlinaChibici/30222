package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Aquatic extends Animal{
	
	//attributes
	private int avgSwimDepth;
	public enum typesOfWater {SALTWATER , FRESHWATER}
	private typesOfWater waterType;
	
	//Constructor
	public Aquatic(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
	}
	
	//methods
	public int getAvgSwimDepth() {
		return avgSwimDepth;
	}
	
	public void setAvgSwimDepth(int avgSwimDepth) {
		this.avgSwimDepth = avgSwimDepth;
	}
	
	public typesOfWater getWaterType() {
		return waterType;
	}
	
	public void setWaterType(typesOfWater waterType) {
		this.waterType = waterType;
	}
	
	@Override
	public double getPredisposition(){
		return super.getPredisposition();
	}
	
	@Override
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode (eventWriter, "avgSwimDepth", String.valueOf(getAvgSwimDepth()));
		createNode (eventWriter, "waterType", String.valueOf(getWaterType()));
	}
	
	@Override
	public void decodeFromXml (Element element){
		setAvgSwimDepth (Integer.valueOf(element.getElementsByTagName("avgSwimDepth").item(0).getTextContent()));
		setWaterType (typesOfWater.valueOf(element.getElementsByTagName("waterType").item(0).getTextContent()));
	}
}
