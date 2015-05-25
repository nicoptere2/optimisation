package optimisation.controller;

import optimisation.model.clavier.ClavierCollection;

public abstract class Algorithme implements Runnable{
	protected ClavierCollection claviers;

	public Algorithme(ClavierCollection claviers) {
		super();
		this.claviers = claviers;
	}

	public abstract void run();
	
	
}
