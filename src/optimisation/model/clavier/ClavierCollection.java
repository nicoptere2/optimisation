package optimisation.model.clavier;

import java.util.ArrayList;
import java.util.Iterator;

public class ClavierCollection implements Iterable<Clavier>{
	private ArrayList<Clavier> clavierCollection;
	
	public ClavierCollection() {
		clavierCollection = new ArrayList<Clavier>();
		initCollection(1);
	}
	
	public void initCollection(int nbClavier) {
		for(int i=0; i<nbClavier; i++)
			clavierCollection.add(new Clavier());
	}
	
	public Iterator<Clavier> iterator() {
		return clavierCollection.iterator();
	}
}
