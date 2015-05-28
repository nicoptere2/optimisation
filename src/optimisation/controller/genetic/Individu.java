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
				if(clavier.getKeys()[i][j].getValue()=='\0')
					continue;
				valueA = String.valueOf(clavier.getKeys()[i][j].getValue());
				for(int k=0; k<4; k++) {
					for(int l=0; l<10; l++) {
						if(clavier.getKeys()[k][l].getValue()=='\0')
							continue;
						valueB = String.valueOf(clavier.getKeys()[k][l].getValue());
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
		char[][] tmpClavier = new char[4][10];
		for(int i=0; i<4; i++) {
			for(int j=0; j<10; j++) {
				tmpClavier[i][j] = this.clavier.getKeys()[i][j].getValue();
			}
		}
		
		char tmpKey;
		int k=0, l=0, n=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<10; j++) {
				tmpKey = mate.clavier.getKeys()[i][j].getValue();
				if(tmpKey == '\0')
					continue;
				
				while(this.clavier.getKeys()[k][l].getValue() == '\0'){
					l++;
					if(l>=10){
						l=0;
						k++;
					}
				}
				//System.out.println("['"+this.clavier.getKeys()[k][l].getValue()+"', '"+tmpKey+"']");
				this.clavier.getKeys()[k][l].setValue(tmpKey);
				l++;
				if(l>=10){
					l=0;
					k++;
				}	
			}
		}
		
		//System.out.println("je passe deja par la..");
		
		l=0; k=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<10; j++) {
				tmpKey = tmpClavier[i][j];
				if(tmpKey == '\0')
					continue;
				
				while(mate.clavier.getKeys()[k][l].getValue() == '\0'){
					l++;
					if(l>=10){
						l=0;
						k++;
					}
				}
				//System.out.println("['"+this.clavier.getKeys()[k][l].getValue()+"', '"+tmpKey+"']");
				mate.clavier.getKeys()[k][l].setValue(tmpKey);
				l++;
				if(l>=10){
					l=0;
					k++;
				}	
			}
		}
		
		return mate;
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
		int ret;
		if(otherFitness < thisFitness)
			ret = 1;
		else if(otherFitness > thisFitness)
			ret = -1;
		else
			ret = 0;
		
		//System.out.println("comparaison : " + otherFitness + " / "+ thisFitness + " retour : " + ret);
		
		return ret;
	}
	
	public String toString() {
		return String.valueOf(this.fitness());
	}

}
