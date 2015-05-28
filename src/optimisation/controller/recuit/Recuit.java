package optimisation.controller.recuit;

import java.util.Random;

import optimisation.controller.Algorithme;
import optimisation.model.Bigramme;
import optimisation.model.Model;
import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.ClavierCollection;

public class Recuit extends Algorithme{
	
	protected int temperature;

	public Recuit(ClavierCollection claviers) {
		super(claviers);
		claviers.initCollection(1);
		temperature = 10000;
	}

	@Override
	public void run() {
		System.out.println("Demarage de l'algorithme recuit");
		
		Clavier c = Model.getInstance().getClavierCollection().getClavierCollection().get(0);
		
		Random r = new Random();
		
		int i = 0,j = 0,k = 0,l = 0;
		char a = '\0';
		char b = '\0';
		double distanceMin = 100;
		double energieMin = 0;
		double energie = 1;
		double varEnergie = energie - energieMin;
		
		while(temperature > 0){
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
			energieMin = 0;
			energie = dist*Bigramme.getInstance().getValue(key);
			varEnergie = energieMin - energie; 
			//System.out.println(key);
			while(varEnergie != 0 && energie != 0){
				energie = dist*Bigramme.getInstance().getValue(key);
				varEnergie = energieMin - energie; 
				//System.out.println(temperature);
				//System.out.println("energie : "+energie);
				//System.out.println(key);
				System.out.println("proba "+Math.exp((-varEnergie)/temperature));
				//System.out.println("varEnergie : "+varEnergie);
				//System.out.println(energie);
				if(varEnergie < 0 && energie != 0){
					System.out.println("switch");
					energieMin = energie;
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
			}
			//System.out.println("sortie de bouble + baisse de T");
			temperature--;
		}
	}

}
