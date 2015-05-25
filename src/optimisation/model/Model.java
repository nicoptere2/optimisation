package optimisation.model;

import optimisation.model.clavier.ClavierCollection;

public class Model {
	
	protected static Model instance = null; 
	
	private ClavierCollection cC;
	
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
		return cC;
	}
}
