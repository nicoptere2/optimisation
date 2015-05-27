package optimisation.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class ViewAlgo extends JPanel{
	
	protected ViewClavierCollection claviers;
	
	public ViewAlgo() {
		this.claviers = new ViewClavierCollection();
		
		this.setPreferredSize(new Dimension(800, 500)) ;
	}
	
	public void execute() {
		claviers.initClaviers();
		repaint();
	}

	
	@Override
    public void paintComponent(Graphics g) {
		
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h, Color.WHITE);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
        
                
        try {
            Thread.sleep(0) ;
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewAlgo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        claviers.dessiner(g2);
        repaint() ;
        
    }
}
