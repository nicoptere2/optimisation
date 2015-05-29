package optimisation.controller.recuit;

import java.util.Random;

import optimisation.controller.Algorithme;
import optimisation.model.Bigramme;
import optimisation.model.Model;
import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.ClavierCollection;

public class Recuit extends Algorithme{
	
	protected double temperature;

	public Recuit(ClavierCollection claviers) {
		super(claviers);
		claviers.initCollection(2);
		temperature = 10000;
	}

	@Override
	public void run() {
		System.out.println("Demarage de l'algorithme recuit");
		
		Clavier c = Model.getInstance().getClavierCollection().getClavierCollection().get(0);
		Clavier s = Model.getInstance().getClavierCollection().getClavierCollection().get(0);
		Clavier best = Model.getInstance().getClavierCollection().getClavierCollection().get(1);
		
		Random r = new Random();
		
		int i = 0,j = 0,k = 0,l = 0;
		char a = '\0';
		char b = '\0';
		double distanceMin = 100;
		double energieSuivant = 0;
		double energie = 1;
		double varEnergie = energie - energieSuivant;
		int temps = 0;
		
		while(temperature > 1 && temps < 5000){
			//r = new Random();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a = '\0';
			b = '\0'; 
			while(a == '\0'){
				i = r.nextInt(10);
				j = r.nextInt(4);
				a = c.getKeys()[j][i].getValue();
			}
			while(b == '\0'){
				k = r.nextInt(10);
				l = r.nextInt(4);
				b = c.getKeys()[l][k].getValue();
			}
			//System.out.println(i);
			//System.out.println(j);
			double dist = Math.sqrt(Math.pow(i-k, 2) + Math.pow(j-l, 2));
			String key = a+""+b;
			//System.out.println(fitness(c));
			//System.out.println("avant "+c);
			s = c.echange(j, i, l, k);
			//System.out.println("apres "+c);
			//System.out.println(fitness(c));
			//System.out.println(best);
			//System.out.println(fitness(best));
			//System.out.println(temps);
			energieSuivant = fitness(s);
			//energie = dist*Bigramme.getInstance().getValue(key);
			energie = fitness(c);
			c.setScore(energie);
			varEnergie = energieSuivant - energie; 
			//System.out.println(key);
			//while(varEnergie != 0 && energie != 0){
				//energie = dist*Bigramme.getInstance().getValue(key);
				//energie = fitness(c);
				//varEnergie = energieSuivant - energie; 
				//System.out.println(temperature);
				//System.out.println("energie : "+energie);
				//System.out.println(key);
				double p = Math.exp((-varEnergie)/temperature);
				//System.out.println("proba "+p);
				//System.out.println(energie);
				System.out.println("varEnergie : "+varEnergie);
				//System.out.println(energie);
				if((varEnergie < 0 && energie != 0) || Math.random() > p){
					/* || Math.random() > p*/
					if(fitness(s) < fitness(best))
						best.setKeys(s.getKeys());
					//System.out.println("switch");
					//System.out.println("apres "+c);
					//System.out.println(fitness(c));
					//System.out.println(best);
					//System.out.println(fitness(best));
					energieSuivant = energie;
					//c.echange(c.getKeys()[l][k], c.getKeys()[j][i]);
					
					if(i < k){
						if(j < l){
							c.echange(c.getKeys()[l][k], c.getKeys()[l-1][k-1]);
							//energieMin = energie;
						}else if(j > l){
							c.echange(c.getKeys()[l][k], c.getKeys()[l+1][k-1]);
							//energieMin = energie;						
						}else{
							c.echange(c.getKeys()[l][k], c.getKeys()[l][k-1]);
							//energieMin = energie;	
						}
					}else if(i >k){
						if(j < l){
							c.echange(c.getKeys()[l][k], c.getKeys()[l-1][k+1]);
							//energieMin = energie;
						}else if(j > l){
							c.echange(c.getKeys()[l][k], c.getKeys()[l+1][k+1]);
							//energieMin = energie;						
						}else{
							c.echange(c.getKeys()[l][k], c.getKeys()[l][k+1]);
							//energieMin = energie;	
						}
					}else{
						if(j < l){
							c.echange(c.getKeys()[l][k], c.getKeys()[l-1][k]);
							//energieMin = energie;
						}else if(j > l){
							c.echange(c.getKeys()[l][k], c.getKeys()[l+1][k]);
							//energieMin = energie;						
						}
					}
				}
			//}
			//System.out.println("sortie de bouble + baisse de T");
			temperature = temperature*0.99999;
			temps++;

		}
		System.out.println("best : "+fitness(best));
	}
	
	public double fitness(Clavier c) {
		double ret = 0;
		int valueBigr;
		double dist = 0;
		String valueA, valueB, tmp ;
		Clavier clavier = c;
		
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

}
