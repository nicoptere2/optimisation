package optimisation.controller.genetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import optimisation.controller.Algorithme;
import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.ClavierCollection;

public class Genetic extends Algorithme{
	
	protected ArrayList<Individu> individus;
	
	public static double pourcentGarde = 0.5;
	
	public static double propMutation = 0.01;
	
	public Genetic(ClavierCollection claviers, int nbIndividu) {
		super(claviers);
		
		individus = new ArrayList<Individu>();
		
		this.claviers.initCollection(nbIndividu);
		
		for(Clavier c: this.claviers) 
			individus.add(new Individu(c));
		
		System.out.println("individus\n"+individus);
	}

	@Override
	public void run() {
		System.out.println("Démarage de l'algorithme génétique");
		
		int j=0;
		while(j<100000) {
			
			//System.out.println(this);
			
			this.sort();
			int garde = (int) (individus.size()*pourcentGarde)-1;
			for(int i=garde; i<individus.size()-2; i++){
				individus.set(i+1, individus.get(i).croisement(individus.get(i+1)));
			}
			
			//for(Individu i: individus)
			//	i.mutation();
			
			j++;
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
