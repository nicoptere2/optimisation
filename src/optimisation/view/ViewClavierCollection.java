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
		
	}
	
	public void initClaviers() {
		clavierCollection.removeAll(clavierCollection);
		int i=0;
		int j=0;
		int tmpY;
		int tmpX;
		for(Clavier c: Model.getInstance().getClavierCollection()){
			tmpY = ViewKey.cote * 5 * i; 
			tmpX = ViewKey.cote * 11 * j;
			clavierCollection.add(new ViewClavier(c, tmpX, tmpY));
			i++;
			if(i%4 == 0)
				j++;
		}
	}
	
	public boolean dessiner(Graphics2D gp) {
		initClaviers();
		for(ViewClavier vc : clavierCollection) 
			vc.dessiner(gp);

		return true;
			
	}

}
