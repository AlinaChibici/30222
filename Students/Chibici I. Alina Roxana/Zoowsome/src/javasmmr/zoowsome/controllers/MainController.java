package javasmmr.zoowsome.controllers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.employees.Caretaker;
import javasmmr.zoowsome.repositories.AnimalRepository;
import javasmmr.zoowsome.repositories.EmployeeRepository;
import javasmmr.zoowsome.services.factories.Constants;
import javasmmr.zoowsome.services.factories.animal.AnimalFactory;
import javasmmr.zoowsome.services.factories.animal.SpeciesFactory;
import javasmmr.zoowsome.services.factories.employee.EmployeeAbstractFactory;
import javasmmr.zoowsome.services.factories.employee.EmployeeFactory;

public class MainController {

	public static void main(String[] args) throws Exception {
		
		AnimalFactory abstractFactory = new AnimalFactory();
		SpeciesFactory speciesFactoryMammal = abstractFactory.getSpeciesFactory(Constants.Species.MAMMAL);
		SpeciesFactory speciesFactoryAquatic = abstractFactory.getSpeciesFactory(Constants.Species.AQUATIC);
		SpeciesFactory speciesFactoryBird = abstractFactory.getSpeciesFactory(Constants.Species.BIRD);
		SpeciesFactory speciesFactoryInsect = abstractFactory.getSpeciesFactory(Constants.Species.INSECT);
		SpeciesFactory speciesFactoryReptile = abstractFactory.getSpeciesFactory(Constants.Species.REPTILE);
	
		Random random = new Random();
		Animal[] zoowsomeAnimals = new Animal[Constants.NUMBER_OF_ANIMALS];
		int randomAnimalCreator;
		
		for(int i = 0; i< Constants.NUMBER_OF_ANIMALS; i++){
			randomAnimalCreator = random.nextInt(15);
			switch (randomAnimalCreator){
				case 0:
					zoowsomeAnimals[i] = speciesFactoryMammal.getAnimal(Constants.Animal.Mammal.GIRAFFE);
					break;
				case 1: 
					zoowsomeAnimals[i] = speciesFactoryMammal.getAnimal(Constants.Animal.Mammal.LION);
					break;
				case 2:
					zoowsomeAnimals[i] = speciesFactoryMammal.getAnimal(Constants.Animal.Mammal.TIGER);
					break;
				case 3:
					zoowsomeAnimals[i] = speciesFactoryAquatic.getAnimal(Constants.Animal.Aquatic.CLOWNFISH);
					break;
				case 4:
					zoowsomeAnimals[i] = speciesFactoryAquatic.getAnimal(Constants.Animal.Aquatic.PIRANHA);
					break;
				case 5:
					zoowsomeAnimals[i] = speciesFactoryAquatic.getAnimal(Constants.Animal.Aquatic.TUNA);
					break;
				case 6:
					zoowsomeAnimals[i] = speciesFactoryBird.getAnimal(Constants.Animal.Bird.EAGLE);
					break;
				case 7:
					zoowsomeAnimals[i] = speciesFactoryBird.getAnimal(Constants.Animal.Bird.PARROT);
					break;
				case 8:
					zoowsomeAnimals[i] = speciesFactoryBird.getAnimal(Constants.Animal.Bird.SWAN);
					break;
				case 9:
					zoowsomeAnimals[i] = speciesFactoryInsect.getAnimal(Constants.Animal.Insect.BUTTERFLY);
					break;
				case 10:
					zoowsomeAnimals[i] = speciesFactoryInsect.getAnimal(Constants.Animal.Insect.MOSQUITO);
					break;
				case 11:
					zoowsomeAnimals[i] = speciesFactoryInsect.getAnimal(Constants.Animal.Insect.SPIDER);
					break;
				case 12:
					zoowsomeAnimals[i] = speciesFactoryReptile.getAnimal(Constants.Animal.Reptile.LIZARD);
					break;
				case 13:
					zoowsomeAnimals[i] = speciesFactoryReptile.getAnimal(Constants.Animal.Reptile.SNAKE);
					break;
				case 14:
					zoowsomeAnimals[i] = speciesFactoryReptile.getAnimal(Constants.Animal.Reptile.TORTOISE);
					break;
			}
		}
		
		EmployeeAbstractFactory abstractEmployeeFactory = new EmployeeAbstractFactory();
		EmployeeFactory employeeFactory = abstractEmployeeFactory.getEmployeeFactory(Constants.Employees.CARETAKER);
		Caretaker[] zoowsomeCaretakers = new Caretaker[Constants.NUMBER_OF_CARETAKERS];
		
		for(int i = 0; i < Constants.NUMBER_OF_CARETAKERS; i++){
			zoowsomeCaretakers[i] = (Caretaker) employeeFactory.getEmployee(Constants.Employees.CARETAKER);
		}
		
		for(int i = 0; i < Constants.NUMBER_OF_CARETAKERS; i++){
			for (int j = 0; j < Constants.NUMBER_OF_ANIMALS; j++){
				if ((!zoowsomeCaretakers[i].getIsDead()) && (!zoowsomeAnimals[j].getTakenCareOf())){
					String result = zoowsomeCaretakers[i].takeCareOf(zoowsomeAnimals[j]);
					if(result.equals(Constants.Employees.Caretakers.TCO_KILLED)){
						zoowsomeCaretakers[i].setIsDead(true);
					}
					else if (result.equals(Constants.Employees.Caretakers.TCO_NO_TIME)){
						continue; //skip to the next animal
					}
					else {
						zoowsomeAnimals[j].setTakenCareOf(true);
					}
				}
			}
		}
		
		for (int i = 0; i < Constants.NUMBER_OF_ANIMALS; i++){
			System.out.println (zoowsomeAnimals[i].getName() + "  - taken care of status: " + zoowsomeAnimals[i].getTakenCareOf()) ;
		}
		
		/*for(int i = 0; i <= Constants.NUMBER_OF_ANIMALS; i++){
			for (@SuppressWarnings("rawtypes") Class clazz : Constants.Animal.class.getClasses()) {
				for (Field field : clazz.getDeclaredFields()) {
					try {
						System.out.println(field.get(clazz));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}*/
	
		ArrayList<Animal> animals = new ArrayList<Animal>();
		for (int i = 0; i < Constants.NUMBER_OF_ANIMALS; i++){
			animals.add(zoowsomeAnimals[i]);
		}
			
		AnimalRepository animalRepository = new AnimalRepository();
		animalRepository.save(animals);
		ArrayList<Animal> loadAnimals = new ArrayList<Animal>();
		loadAnimals = animalRepository.load();
		
		ArrayList<Caretaker> caretakers = new ArrayList<Caretaker>();
		EmployeeRepository employeeRepository = new EmployeeRepository();
		for(int i = 0; i < Constants.NUMBER_OF_CARETAKERS; i++){
			caretakers.add(zoowsomeCaretakers[i]);
		}
		employeeRepository.save(caretakers);
		ArrayList<Caretaker> loadCaretakers = new ArrayList<Caretaker>();
		loadCaretakers = employeeRepository.load();
	}
}
