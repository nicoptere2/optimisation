package optimisation.controller.genetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import optimisation.controller.Algorithme;
import optimisation.model.Model;
import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.ClavierCollection;

public class Genetic extends Algorithme{
	
	protected ArrayList<Individu> individus;
	
	public static double pourcentGarde = 0.5;
	
	public static double propMutation = 0.20;
	
	public Genetic(ClavierCollection claviers, int nbIndividu) {
		super(claviers);
		
		individus = new ArrayList<Individu>();
		
		this.claviers.initCollection(nbIndividu+1);
		
		for(Clavier c: this.claviers) 
			individus.add(new Individu(c));
	}

	@Override
	public void run() {
		System.out.println("Démarage de l'algorithme génétique");
		
		int j=0;
		while(j<100000) {
			
			this.sort();
			
			this.individus.get(0).good();
		
			//System.out.println(this);
			
			Clavier best = Model.getInstance().getClavierCollection().getClavierCollection().get(0);
			best.setKeys(individus.get(0).getClavier().getKeys());
			best.setScore(individus.get(0).getFitness());
			
			int garde = (int) (individus.size()*pourcentGarde);

			for(int i=garde; i<individus.size()-1; i+=2){
				individus.set(i+1, individus.get(i).croisement(individus.get(i+1)));
			}
			
			for(int i=1; i<individus.size()-1; i++){
				individus.get(i).mutation();
			}
			
			Model.getInstance().setIteration(j++);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void sort() {
		Collections.sort(individus);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Individu i: individus)
			s.append(i+"\n");
		
		return s.toString();
	}
}
