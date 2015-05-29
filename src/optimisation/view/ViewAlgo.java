package optimisation.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JTextField;

import optimisation.model.Model;

public class ViewAlgo extends JPanel{
	
	protected ViewClavierCollection claviers;
	
	protected JTextField iteration;
	
	public static int refresh = 5;
	
	public ViewAlgo() {
		this.claviers = new ViewClavierCollection();
		
		this.setPreferredSize(new Dimension(300, 550)) ;
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
            Thread.sleep(refresh) ;
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewAlgo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        printIteration(g2);
        
        claviers.dessiner(g2);
        repaint() ;
        
    }

	private void printIteration(Graphics2D g) {
		String  s = "Nombre d'iteration : "+String.valueOf(Model.getInstance().getIteration());
    	
        // Find the size of string s in the font of the Graphics context 
        FontMetrics fm = g.getFontMetrics();
        int xC = (fm.stringWidth(s)) / 2;
        int yC = (fm.getAscent() + ((fm.getAscent() + fm.getDescent())) / 2);
        g.setColor(Color.black);
        // Center text horizontally and vertically within provided rectangular bounds
        g.drawString(s, xC , yC + 500);
	}
}
