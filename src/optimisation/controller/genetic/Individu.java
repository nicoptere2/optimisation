package optimisation.controller.genetic;

import optimisation.model.clavier.Clavier;

public class Individu implements Comparable{
	
	private Clavier clavier;

	public Individu(Clavier c) {
		this.clavier = c;
	}
	
	public float fitness() {
		return 0;
	}
	
	public Individu croisement(Individu mate) {
		return null;
	}
	
	public void mutation() {
		
	}

	@Override
	public int compareTo(Object arg0) {
		float otherFitness = ((Individu) arg0).fitness();
		float thisFitness = this.fitness();
		
		if(otherFitness < thisFitness)
			return 1;
		else if(otherFitness > thisFitness)
			return -1;
		else
			return 0;

	}

}
