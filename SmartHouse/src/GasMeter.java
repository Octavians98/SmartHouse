
public class GasMeter extends Meter {
	
	
	
	public GasMeter(int consumed, int generated, boolean canGenerate) {
		super(consumed, generated, canGenerate);
	
	}

	public String getType(){
		return "gas";
	}

}
