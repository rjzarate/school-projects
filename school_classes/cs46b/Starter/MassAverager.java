package size;

import java.util.ArrayList;

public class MassAverager {
	
	private ArrayList<Matter> members;
	
	MassAverager() {
		members = new ArrayList<Matter>();
	}
	
	public void add(Matter m) {
		members.add(m);
	}
	
	public double getAverageMassKgs() {
		double totalMass = 0;
		for(Matter m: members) {
			totalMass += m.getMassKgs();
		}
		return totalMass/members.size();
	}
	
	public static void main(String[] args) {
		MassAverager ma = new MassAverager();
		ma.add(new Star(1000));
		ma.add(new Athlete(220)); //about 100 Kgs
		System.out.println(ma.getAverageMassKgs());
	}

}
