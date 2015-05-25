package optimisation.view;

import java.awt.Graphics2D;
import java.util.ArrayList;

import optimisation.model.Model;
import optimisation.model.clavier.Clavier;

public class ViewClavierCollection {
	
	private ArrayList<ViewClavier> clavierCollection;

	public ViewClavierCollection() {
		super();
		clavierCollection = new ArrayList<ViewClavier>();
		int i=0;
		int tmpY;
		for(Clavier c: Model.getInstance().getClavierCollection()){
			tmpY = ViewKey.cote * 5 *i; 
			clavierCollection.add(new ViewClavier(c, 0, tmpY));
			i++;
		}
	}
	
	public boolean dessiner(Graphics2D gp) {
		for(ViewClavier vc : clavierCollection) 
			vc.dessiner(gp);

		return true;
			
	}

}
