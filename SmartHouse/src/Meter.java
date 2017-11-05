
public abstract class Meter {
	
	int consumed;
	int generated;
	boolean canGenerate;
	
	
	
	public Meter(int consumed, int generated, boolean canGenerate) {
		super();
		this.consumed = consumed;
		this.generated = generated;
		this.canGenerate = canGenerate;
	}

	public void incrementConsumed(){
		consumed++;
		
	}
	
	public void incrementConsumed(int addConsumed){//Incrementing the consume with a certain amount using an overloaded method
		
		consumed = consumed+addConsumed;
	}
	
	public void incrementGenerated(){
		generated++;
		
	}
	
	public void incrementGenerated(int addGenerated){//Incrementing how much was generated with a certain amount using an overloaded method
		
		generated=generated+addGenerated;
		
	}
	
	public boolean canGenerate(){//Returns if the resource can be generated
		
		return canGenerate;
	}
	
	public int getConsumed(){//Returns how much resources were consumed
		
		return consumed;
	}
	
	public int getGenerated(){//Return how much resources were generated
		
		return generated;
		
	}
	
	public abstract String getType();//Get the type of meter(elecrtic, gas or water meter)
	
	
	

}
