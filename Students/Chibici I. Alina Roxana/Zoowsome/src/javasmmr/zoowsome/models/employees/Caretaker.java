package javasmmr.zoowsome.models.employees;

import java.math.BigDecimal;
import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.services.factories.Constants;

public class Caretaker extends Employee implements Caretaker_I{
	
	//attributes
	private double workingHours;
	
	//constructor
	public Caretaker(String name, long id, BigDecimal salary, double workingHours) {
		super(name, id, salary);
		this.workingHours = workingHours;
	}
	
	public Caretaker() {
		this ("caretaker", (long)1, BigDecimal.valueOf(2500), (double)40);
	}
	
	//methods
	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	
	@Override
	public String takeCareOf(Animal animal) {
		if (animal.kill()){    
			return Constants.Employees.Caretakers.TCO_KILLED;   
		}      
		if (this.workingHours < animal.getMaintenanceCost()){    
			return Constants.Employees.Caretakers.TCO_NO_TIME;   
		}  
		animal.setTakenCareOf(true);
		this.workingHours -= animal.getMaintenanceCost();     
		return Constants.Employees.Caretakers.TCO_SUCCESS;     
	}
	
}
