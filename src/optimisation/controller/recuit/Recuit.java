package optimisation.controller.recuit;

import optimisation.controller.Algorithme;
import optimisation.model.clavier.ClavierCollection;

public class Recuit extends Algorithme{

	public Recuit(ClavierCollection claviers) {
		super(claviers);
		claviers.initCollection(1);
	}

	@Override
	public void run() {
		System.out.println("Démarage de l'algorithme recuit");
	}

}
