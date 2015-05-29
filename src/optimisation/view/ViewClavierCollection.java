package optimisation.view;

import java.awt.Graphics2D;
import java.util.ArrayList;

import optimisation.model.Model;
import optimisation.model.clavier.Clavier;

public class ViewClavierCollection {
	
	private ArrayList<ViewClavier> clavierCollection;
	private ViewClavier best = null;

	public ViewClavierCollection() {
		super();
		clavierCollection = new ArrayList<ViewClavier>();
		
	}
	
	public void initClaviers() {
		clavierCollection.removeAll(clavierCollection);
		int i=0;
		int j=0;
		int tmpY;
		int tmpX;
		
		ArrayList<Clavier> c = Model.getInstance().getClavierCollection().getClavierCollection();
		for(int n=0; n<c.size() && n<4; n++){
			
			tmpY = ViewKey.cote * 5 * i; 
			clavierCollection.add(new ViewClavier(c.get(n), 0, tmpY));
			i++;
			if(i%4 == 0)
				j++;
		}
		
		if(Model.getInstance().getClavierCollection().best != null)
			best = new ViewClavier(Model.getInstance().getClavierCollection().best, ViewKey.cote * 11, 0);
	}
	
	public synchronized boolean dessiner(Graphics2D gp) {		
		for(ViewClavier vc : clavierCollection) {
			vc.dessiner(gp);
		}
		if(!clavierCollection.isEmpty())
			clavierCollection.get(0).dessiner(gp,true);
		
		if(best != null)
			best.dessiner(gp);

		return true;
			
	}

}
