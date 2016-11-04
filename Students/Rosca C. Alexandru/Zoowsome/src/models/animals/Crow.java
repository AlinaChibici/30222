package models.animals;

public class Crow extends Bird{

	private int weight; 
	
	public Crow(){
		nrOfLegs = 2;
		name = "Crow";
		avgFlightAltitude = 20;
		migrate = false;
		setWeight(4);
	}
	
	public Crow(int weight, boolean migrate, int avgFlightAltitude){
		this();
		this.setWeight(weight);
		this.migrate = migrate;
		this.avgFlightAltitude = avgFlightAltitude;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
