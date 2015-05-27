package optimisation.controller.recuit;

import optimisation.controller.Algorithme;
import optimisation.model.Model;
import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.ClavierCollection;

public class Recuit extends Algorithme{
	
	protected int temperature;

	public Recuit(ClavierCollection claviers) {
		super(claviers);
		claviers.initCollection(1);
		temperature = 1000;
	}

	@Override
	public void run() {
		System.out.println("Démarage de l'algorithme recuit");
		
		Clavier c = Model.getInstance().getClavierCollection().getClavierCollection().get(0);
		
		int i = (int)Math.random()*9;
		int j = (int)Math.random()*3;
		char a = c.getKeys()[i][j].getValue();
		System.out.println(a);
		if(a != ' '){
		}
		//double dist = Math.sqrt(Math.pow(i-k, 2) + Math.pow(j-l, 2));
	}

}
