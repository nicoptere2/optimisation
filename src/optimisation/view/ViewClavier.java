package optimisation.view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import optimisation.model.clavier.Clavier;
import optimisation.model.clavier.Key;

public class ViewClavier {
	private Clavier clavier;
	
	private ArrayList<ViewKey> keys;
	
	private int x;
	private int y;
	
	
	public ViewClavier(Clavier c, int x, int y) {
		keys = new ArrayList<ViewKey>();
		
		this.x = x;
		this.y = y;
		
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

	public boolean dessiner(Graphics2D g) {
		for(ViewKey k : keys)
			k.dessiner(g);
		
    	String  s = String.valueOf(clavier.getScore());
    	
        // Find the size of string s in the font of the Graphics context 
        FontMetrics fm = g.getFontMetrics();
        int xC = (fm.stringWidth(s)) / 2;
        int yC = (fm.getAscent() + ((fm.getAscent() + fm.getDescent())) / 2);
        g.setColor(Color.black);
        // Center text horizontally and vertically within provided rectangular bounds
        g.drawString(s, xC + this.x, yC + this.y + 4*ViewKey.cote);
        
        
		return true;
	}
	
	public boolean dessiner(Graphics2D g,boolean b) {
		for(ViewKey k : keys)
			k.dessiner(g);
		
    	String  s = String.valueOf(clavier.getScore());
    	
        // Find the size of string s in the font of the Graphics context 
        FontMetrics fm = g.getFontMetrics();
        int xC = (fm.stringWidth(s)) / 2;
        int yC = (fm.getAscent() + ((fm.getAscent() + fm.getDescent())) / 2);
        g.setColor(Color.green);
        // Center text horizontally and vertically within provided rectangular bounds
        g.drawString(s, xC + this.x, yC + this.y + 4*ViewKey.cote);
        
        
		return true;
	}

	public Clavier getClavier() {
		return this.clavier;
	}
}
