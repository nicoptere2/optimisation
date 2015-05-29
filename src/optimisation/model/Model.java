package optimisation.model;

import optimisation.model.clavier.ClavierCollection;

public class Model {
	
	protected static Model instance = null; 
	
	private ClavierCollection cC;
	
	private int nbIteration = 0;
	
	public static Model getInstance() {
		if(instance == null)
			instance = new Model();
		
		return instance;
	}
	
	public Model() {
		cC = new ClavierCollection();
		instance = this;
	}
	
	public ClavierCollection getClavierCollection() {
		//System.out.println("taille : "+cC.size());
		return cC;
	}
	
	

	public int getIteration() {
		return this.nbIteration;
	}

	public void setIteration(int nb) {
		this.nbIteration = nb;
	}
}
