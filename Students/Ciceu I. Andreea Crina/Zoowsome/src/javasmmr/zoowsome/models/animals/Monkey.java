package javasmmr.zoowsome.models.animals;

public class Monkey extends Mammal {
	public Monkey (int nrOfLegs, String name, float normalBodyTemp, float percBodyHair) {
		setNrOfLegs(nrOfLegs);
		setName(name);
		setNormalBodyTemp(normalBodyTemp);
		setPercBodyHair(percBodyHair);
		
	}
	public Monkey() {
		this(4, "MojoJojo", 40, 68);
	}

}
