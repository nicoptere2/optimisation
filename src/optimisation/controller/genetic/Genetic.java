package optimisation.controller.genetic;

import java.util.ArrayList;
import java.util.Collections;

import optimisation.controller.Algorithme;
import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.ClavierCollection;

public class Genetic extends Algorithme{
	
	protected ArrayList<Individu> individus;
	
	protected double pourcentGarde = 0.5;
	
	protected double propMutation = 0.1;
	
	public Genetic(ClavierCollection claviers, int nbIndividu) {
		super(claviers);
		
		individus = new ArrayList<Individu>();
		
		this.claviers.initCollection(nbIndividu);
		
		for(Clavier c: this.claviers) 
			individus.add(new Individu(c));
	}

	@Override
	public void run() {
		System.out.println("Démarage de l'algorithme génétique");
		
		this.sort();
		
				
		int garde = (int) (individus.size()*pourcentGarde);	
		for(int i=garde; i<individus.size()-1; i++){
			individus.set(i+1, individus.get(i).croisement(individus.get(i+1)));
		}
		
		
		for(Individu i: individus)
			i.mutation();
	}
	
	protected void sort() {
		Collections.sort(individus);
	}
}
