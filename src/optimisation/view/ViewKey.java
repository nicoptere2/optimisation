package optimisation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import optimisation.model.clavier.Key;

public class ViewKey extends BufferedImage {

	protected Key key;
	
    protected Graphics2D carre ;
    public static int cote = 25 ;
    
    private int x;
    private int y;
    
   
    
    /**
     * Instanciation d'un élément graphique à dessiner (ici un carré)
     * @param v chaîne de caractère à écrire au centre de d'élément graphique
     * @param x abscisse initiale de l'élément graphique dans la fenêtre
     * @param y ordonnée initiale de l'élément graphique dans la fenêtre
     */
    public ViewKey(Key k, int x, int y) {
        super(150, 150, BufferedImage.TYPE_INT_ARGB);
        
        key = k;
        
        this.x = x;
        this.y = y;
        
        carre = createGraphics();
       
        
        dessinerCase() ;
    }
    
   
    
    /**
     * Dessin de l'élément graphique (l'élément graphique est redessiné, car sa couleur et son contenu peuvent 
     * changer au cours de l'animation
     * @param t temps courant
     */
    private void dessinerCase() {
        carre.setPaint(Color.white) ;
        carre.fillRect(0, 0, cote, cote) ;
        
        carre.setColor(Color.black) ;
        carre.drawRect(0, 0, cote, cote); 

        carre.setFont(new Font("Arial", Font.BOLD, 16));
        dessinerChaineAuCentre(0, 0, cote, carre);  
    }

    /**
     * Fonction pour centrer la chaîne de caractères dans l'élément graphique
     * @param w abscisse initiale relative de la chaîne par rapport à l'élément graphique
     * @param h ordonnée initiale relative de la chaîne par rapport à l'élément graphique
     * @param c largeur de l'élément dans lequel on centre la chaîne
     * @param g élément graphique
     * @param t temps courant
     */
    private void dessinerChaineAuCentre(int w, int h, int c, Graphics2D g) {
    	char tmp = (key.getValue() == '\0')? ' ' : key.getValue();
    	String  s = Character.toString(tmp);
    	
        // Find the size of string s in the font of the Graphics context 
        FontMetrics fm = g.getFontMetrics();
        int xC = (c - fm.stringWidth(s)) / 2;
        int yC = (fm.getAscent() + (c - (fm.getAscent() + fm.getDescent())) / 2);
        
        // Center text horizontally and vertically within provided rectangular bounds
        g.drawString(s, xC + w, yC + h);
    } 

    
    /**
     * Dessin de l'élément graphique et positionnement dans la fenêtre graphique
     * @param g fenêtre graphique dans laquelle on dessine
     * @param init 
     */
    public boolean dessiner(Graphics g) {
    	dessinerCase();
    	g.drawImage(this, this.x, this.y, null);

    	return true;

    } 

}
