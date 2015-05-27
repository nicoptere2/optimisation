package optimisation.controller.genetic;

import java.util.Random;

import optimisation.model.Bigramme;
import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.Key;

public class Individu implements Comparable{
	
	private Clavier clavier;

	public Individu(Clavier c) {
		this.clavier = c;
	}
	
	public double fitness() {
		double ret = 0;
		int valueBigr;
		double dist = 0;
		String valueA, valueB, tmp ;
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<10; j++){
				valueA = String.valueOf(clavier.getKeys()[i][j].getValue());
				if(valueA.isEmpty())
					continue;
				for(int k=0; k<4; k++) {
					for(int l=0; l<10; l++) {
						valueB = String.valueOf(clavier.getKeys()[k][l].getValue());
						if(valueB.isEmpty())
							continue;
						tmp = valueA + valueB;
						valueBigr = Bigramme.getInstance().getValue(tmp);
						dist = Math.sqrt(Math.pow(i-k, 2) + Math.pow(j-l, 2));
						ret += dist * valueBigr;
					}
				}
				valueA = "";
			}
		}
		
		return ret;
	}
	
	public Individu croisement(Individu mate) {
		return null;
	}
	
	public void mutation() {
		Random r = new Random();
		if((double)(r.nextInt(100))/100 < Genetic.propMutation) {
			clavier.echange(clavier.getKeys()[r.nextInt(4)][r.nextInt(10)], clavier.getKeys()[r.nextInt(4)][r.nextInt(10)]);
		}
	}

	public int compareTo(Object arg0) {
		double otherFitness = ((Individu) arg0).fitness();
		double thisFitness = this.fitness();
		if(otherFitness < thisFitness)
			return 1;
		else if(otherFitness > thisFitness)
			return -1;
		else
			return 0;
	}
	
	public String toString() {
		return String.valueOf(this.fitness());
	}

}
