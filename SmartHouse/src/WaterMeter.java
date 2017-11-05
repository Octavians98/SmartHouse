
public class WaterMeter extends Meter {


	
	public WaterMeter(int consumed, int generated, boolean canGenerate) {
		super(consumed, generated, canGenerate);
		
	}

	public String getType(){
		return "water";
	}

}
