package size;

public class Athlete implements Matter {

	private double weight;
	
	Athlete(double weight){
		this.weight = weight;
	}
	
	public double getMassKgs() {
		return weight*0.454;
	}
	
	public double getWeightPounds() {
		return weight;
	}
	
	
}
