package javasmmr.zoowsome.services.factories;

public final class Constants {
	
	public static final int NUMBER_OF_ANIMALS = 50;
	public static final int NUMBER_OF_CARETAKERS = 30;
	
	public static final class Species {   
		public static final String MAMMAL = "MAMMAL";   
		public static final String REPTILE = "REPTILE";   
		public static final String BIRD = "BIRD";   
		public static final String AQUATIC = "AQUATIC";   
		public static final String INSECT = "INSECT";  
	}  
	
	public static final class Animal {
		
		public static final class Mammal {   
			public static final String GIRAFFE = "GIRAFFE";   
			public static final String TIGER = "TIGER";    
			public static final String LION = "LION";   
		 }  
	 
		public static final class Reptile {    
			public static final String LIZARD = "LIZARD";   
			public static final String SNAKE = "SNAKE"; 
			public static final String TORTOISE = "TORTOISE"; 
		}
		
		public static final class Bird { 
			public static final String EAGLE = "EAGLE";
			public static final String PARROT = "PARROT";
			public static final String SWAN = "SWAN";	
		}
	 
		public static final class Aquatic {  
			public static final String TUNA = "TUNA";
			public static final String CLOWNFISH = "CLOWNFISH";
			public static final String PIRANHA = "PIRANHA";
		}
		
		public static final class Insect {
			public static final String BUTTERFLY = "BUTTERFLY";
			public static final String MOSQUITO = "MOSQUITO";
			public static final String SPIDER = "SPIDER";
		} 
	}
	
	public static final class Employees {
		public static final String CARETAKER = "CARETAKER";
		public static final class Caretakers {    
			  public static final String TCO_SUCCESS = "SUCCESS";    
			  public static final String TCO_KILLED = "KILLED";    
			  public static final String TCO_NO_TIME = "NO_TIME";   
		  } 
	}
	
	public static final class XML_TAGS{
		public static final String ANIMAL = null; //not sure what to write here
		public static final String DISCRIMINANT = null;
		public static final String CARETAKER = null;
	}
}


