package optimisation.controller.recuit;

import java.util.Random;

import optimisation.controller.Algorithme;
import optimisation.model.Model;
import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.ClavierCollection;

public class Recuit extends Algorithme{
	
	protected int temperature;

	public Recuit(ClavierCollection claviers) {
		super(claviers);
		claviers.initCollection(1);
		temperature = 100000000;
	}

	@Override
	public void run() {
		System.out.println("Démarage de l'algorithme recuit");
		
		Clavier c = Model.getInstance().getClavierCollection().getClavierCollection().get(0);
		
		Random r = new Random();
		
		int i = 0,j = 0,k = 0,l = 0;
		char a = '\0';
		char b = '\0';
		double distanceMin = 100;
		
		while(temperature > 0){
			//r = new Random();
			try {
				Thread.sleep(1000);
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
			System.out.println(i);
			System.out.println(j);
			double dist = Math.sqrt(Math.pow(i-k, 2) + Math.pow(j-l, 2));
			if(dist <= distanceMin){
				if(i < k){
					if(j < l){
						c.echange(c.getKeys()[l][k], c.getKeys()[l-1][k-1]);
						//distanceMin = dist;
					}else if(j > l){
						c.echange(c.getKeys()[l][k], c.getKeys()[l+1][k-1]);
						//distanceMin = dist;						
					}else{
						c.echange(c.getKeys()[l][k], c.getKeys()[l][k-1]);
						//distanceMin = dist;	
					}
				}else if(i >k){
					if(j < l){
						c.echange(c.getKeys()[l][k], c.getKeys()[l-1][k+1]);
						//distanceMin = dist;
					}else if(j > l){
						c.echange(c.getKeys()[l][k], c.getKeys()[l+1][k+1]);
						//distanceMin = dist;						
					}else{
						c.echange(c.getKeys()[l][k], c.getKeys()[l][k+1]);
						//distanceMin = dist;	
					}
				}else{
					if(j < l){
						c.echange(c.getKeys()[l][k], c.getKeys()[l-1][k]);
						//distanceMin = dist;
					}else if(j > l){
						c.echange(c.getKeys()[l][k], c.getKeys()[l+1][k]);
						//distanceMin = dist;						
					}
				}
			}
			System.out.println(dist);
			temperature--;
		}
	}

}
