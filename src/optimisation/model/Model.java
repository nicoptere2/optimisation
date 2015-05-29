package optimisation.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import optimisation.model.clavier.ClavierCollection;

public class Model {
	
	protected static Model instance = null; 
	
	private ClavierCollection cC;
	
	public Lock lock;
	
	public static Model getInstance() {
		if(instance == null)
			instance = new Model();
		
		return instance;
	}
	
	public Model() {
		cC = new ClavierCollection();
		lock = new ReentrantLock();
		instance = this;
	}
	
	public ClavierCollection getClavierCollection() {
		//System.out.println("taille : "+cC.size());
		return cC;
	}
}
