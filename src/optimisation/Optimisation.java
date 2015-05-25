package optimisation;

import javax.swing.JFrame;

import optimisation.model.Model;
import optimisation.view.View;

public class Optimisation extends JFrame{
	
	public Optimisation() {		
		super("Projet d'optimisation : le Meilleur Clavier");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        new Model();
        
        View view = new View();
        this.add(view);
        
        pack();
        setVisible(true); 
	}

	public static void main(String[] args) {
		new Optimisation();
	}

}
