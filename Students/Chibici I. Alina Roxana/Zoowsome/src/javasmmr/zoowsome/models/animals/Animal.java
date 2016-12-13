package javasmmr.zoowsome.models.animals;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import java.util.Random;
import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Element;

public abstract class Animal implements Killer, XML_Parsable {
	
	//attributes
	private int nrOfLegs = 0;
	private String name = "Undefined";
	private double maintenanceCost;
	private double dangerPerc;
	private Boolean takenCareOf = false;
	
	//constructors
	public Animal (double maintenanceCost, double dangerPerc){
		this.maintenanceCost = maintenanceCost;
		this.dangerPerc = dangerPerc;
	}

	//methods
	public int getNrOfLegs(){
		return nrOfLegs;
	}
	
	public void setNrOfLegs(int nrOfLegs){
		this.nrOfLegs = nrOfLegs;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getMaintenanceCost(){
		return this.maintenanceCost;
	}
	
	private void setMaintenanceCost(Double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;	
	}
	
	public double getdangerPerc(){
		return this.dangerPerc;
	}
	
	private void setDangerPerc(Double dangerPerc) {
		this.dangerPerc = dangerPerc;
	}
	
	public boolean kill(){
		Random random = new Random ();
		double chance;
		chance = random.nextDouble();
		if (chance < (dangerPerc + this.getPredisposition())){
			return true;
		}
		else {
			return false;
		}	
	}
	
	public Boolean getTakenCareOf() {
		return takenCareOf;
	}
	
	public void setTakenCareOf(Boolean takenCareOf) {
		this.takenCareOf = takenCareOf;
	}
	
	public double getPredisposition(){
		return 0;
	}
	
	public void encodeToXml (XMLEventWriter eventWriter) throws XMLStreamException {
		createNode (eventWriter, "nrOfLegs", String.valueOf(this.nrOfLegs));
		createNode (eventWriter, "name", String.valueOf(this.name));
		createNode (eventWriter, "maintenanceCost", String.valueOf(this.maintenanceCost));
		createNode (eventWriter, "dangerPerc", String.valueOf(this.dangerPerc));
		createNode (eventWriter, "takenCareOf", String.valueOf(this.takenCareOf));
	}
	
	public void decodeFromXml (Element element){
		setNrOfLegs (Integer.valueOf(element.getElementsByTagName("nrOfLegs").item(0).getTextContent()));
		setName (element.getElementsByTagName("name").item(0).getTextContent());
		setMaintenanceCost (Double.valueOf(element.getElementsByTagName("maintenanceCost").item(0).getTextContent()));
		setDangerPerc (Double.valueOf(element.getElementsByTagName("dangerPerc").item(0).getTextContent()));
		setTakenCareOf (Boolean.valueOf(element.getElementsByTagName("takenCareOf").item(0).getTextContent()));
	}
}
