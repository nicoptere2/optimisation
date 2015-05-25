package optimisation.view.elementGraphique;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener{
	  
	private boolean clicked = false;

	public Bouton(String title, String tooltip) {
	    super(title);

	    this.setToolTipText(tooltip);
	    
	    this.addMouseListener(this);
	}
	
	public boolean hasBeenClicked() {
		return clicked;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
