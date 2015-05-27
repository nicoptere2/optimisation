package optimisation.model.clavier;

import java.util.ArrayList;
import java.util.Iterator;

public class ClavierCollection implements Iterable<Clavier>{
	private ArrayList<Clavier> clavierCollection;
	
	public ClavierCollection() {
		clavierCollection = new ArrayList<Clavier>();
	}
	
	public void initCollection(int nbClavier) {
		clavierCollection.removeAll(clavierCollection);
		for(int i=0; i<nbClavier; i++)
			clavierCollection.add(new Clavier());
	}
	
	public synchronized Iterator<Clavier> iterator() {
		return clavierCollection.iterator();
	}

	public int size() {
		return clavierCollection.size();
	}

	public ArrayList<Clavier> getClavierCollection() {
		return clavierCollection;
	}

	public void setClavierCollection(ArrayList<Clavier> clavierCollection) {
		this.clavierCollection = clavierCollection;
	}
	
	
}
