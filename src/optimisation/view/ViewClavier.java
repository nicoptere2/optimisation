package optimisation.view;

import java.awt.Graphics2D;
import java.util.ArrayList;

import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.Key;

public class ViewClavier {
	private Clavier clavier;
	
	private ArrayList<ViewKey> keys;
	
	public ViewClavier(Clavier c, int x, int y) {
		keys = new ArrayList<ViewKey>();
		
		this.clavier = c;
		
		int tmpX = x;
		int tmpY = y;
		
		int i=0;
		
		for(Key k: this.clavier) {
			keys.add(new ViewKey(k, tmpX, tmpY));
			i++;
			if(i%10 == 0){
				tmpX = x;
				tmpY += ViewKey.cote;
			}
			else {
				tmpX += ViewKey.cote;
			}
		}
	}

	public boolean dessiner(Graphics2D gp) {
		for(ViewKey k : keys)
			k.dessiner(gp);
		
		return true;
	}
}
