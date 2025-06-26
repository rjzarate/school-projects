package size;

public class Star implements Matter{
	
	private double mass;
	
	Star(double mass){
		this.mass = mass;
	}
	
	public double getMassKgs() {
		return mass;
	}
	
	public double getWeightPounds() {
		return mass/2.2;
	}
	
}
